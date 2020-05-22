public static <E> Stream<E> proxy(Stream<E> src) {
    Class<Stream<E>> sClass=(Class)Stream.class;
    Class<Spliterator<E>> spClass=(Class)Spliterator.class;
    return proxy(src, sClass, spClass, StreamSupport::stream);
}
public static IntStream proxy(IntStream src) {
    return proxy(src, IntStream.class, Spliterator.OfInt.class, StreamSupport::intStream);
}
public static LongStream proxy(LongStream src) {
    return proxy(src, LongStream.class, Spliterator.OfLong.class, StreamSupport::longStream);
}
public static DoubleStream proxy(DoubleStream src) {
    return proxy(src, DoubleStream.class, Spliterator.OfDouble.class, StreamSupport::doubleStream);
}
static final Object EMPTY=new StringBuilder("empty");
static <E,S extends BaseStream<E,S>, Sp extends Spliterator<E>> S proxy(
        S src, Class<S> sc, Class<Sp> spc, BiFunction<Sp,Boolean,S> f) {

    final class Node<T> implements InvocationHandler,Runnable,
        Consumer<Object>, IntConsumer, LongConsumer, DoubleConsumer {
        final Class<? extends Spliterator> type;
        Spliterator<T> src;
        Object first=EMPTY, last=EMPTY;
        Node<T> left, right;
        Object currConsumer;
        public Node(Spliterator<T> src, Class<? extends Spliterator> type) {
            this.src = src;
            this.type=type;
        }
        private void value(Object t) {
            if(first==EMPTY) first=t;
            last=t;
        }
        public void accept(Object t) {
            value(t); ((Consumer)currConsumer).accept(t);
        }
        public void accept(int t) {
            value(t); ((IntConsumer)currConsumer).accept(t);
        }
        public void accept(long t) {
            value(t); ((LongConsumer)currConsumer).accept(t);
        }
        public void accept(double t) {
            value(t); ((DoubleConsumer)currConsumer).accept(t);
        }
        public void run() {
            System.out.println();
            finish().forEach(System.out::println);
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Node<T> curr=this; while(curr.right!=null) curr=curr.right;
            if(method.getName().equals("tryAdvance")||method.getName().equals("forEachRemaining")) {
                curr.currConsumer=args[0];
                args[0]=curr;
            }
            if(method.getName().equals("trySplit")) {
                Spliterator s=curr.src.trySplit();
                if(s==null) return null;
                Node<T> pfx=new Node<>(s, type);
                pfx.left=curr.left; curr.left=pfx;
                curr.right=new Node<>(curr.src, type);
                src=null;
                return pfx.create();
            }
            return method.invoke(curr.src, args);
        }
        Object create() {
            return Proxy.newProxyInstance(null, new Class<?>[]{type}, this);
        }
        String pad(String s, int left, int len) {
            if (len == s.length())
                return s;
            char[] result = new char[len];
            Arrays.fill(result, ' ');
            s.getChars(0, s.length(), result, left);
            return new String(result);
        }
        public List<String> finish() {
            String cur = toString();
            if (left == null) {
                return Collections.singletonList(cur);
            }
            List<String> l = left.finish();
            List<String> r = right.finish();
            int len1 = l.get(0).length();
            int len2 = r.get(0).length();
            int totalLen = len1 + len2 + 1;
            int leftAdd = 0;
            if (cur.length() < totalLen) {
                cur = pad(cur, (totalLen - cur.length()) / 2, totalLen);
            } else {
                leftAdd = (cur.length() - totalLen) / 2;
                totalLen = cur.length();
            }
            List<String> result = new ArrayList<>();
            result.add(cur);

            char[] dashes = new char[totalLen];
            Arrays.fill(dashes, ' ');
            Arrays.fill(dashes, len1 / 2 + leftAdd + 1, len1 + len2 / 2 + 1
                    + leftAdd, '_');
            int mid = totalLen / 2;
            dashes[mid] = '/';
            dashes[mid + 1] = '\\';
            result.add(new String(dashes));

            Arrays.fill(dashes, ' ');
            dashes[len1 / 2 + leftAdd] = '|';
            dashes[len1 + len2 / 2 + 1 + leftAdd] = '|';
            result.add(new String(dashes));

            int maxSize = Math.max(l.size(), r.size());
            for (int i = 0; i < maxSize; i++) {
                String lstr = l.size() > i ? l.get(i) : String.format("%"
                        + len1 + "s", "");
                String rstr = r.size() > i ? r.get(i) : String.format("%"
                        + len2 + "s", "");
                result.add(pad(lstr + " " + rstr, leftAdd, totalLen));
            }
            return result;
        }
        private Object first() {
            if(left==null) return first;
            Object o=left.first();
            if(o==EMPTY) o=right.first();
            return o;
        }
        private Object last() {
            if(right==null) return last;
            Object o=right.last();
            if(o==EMPTY) o=left.last();
            return o;
        }
        public String toString() {
            Object o=first(), p=last();
            return o==EMPTY? "(empty)": "["+o+(o!=p? ".."+p+']': "]");
        }
    }
    Node<E> n=new Node<>(src.spliterator(), spc);
    Sp sp=(Sp)Proxy.newProxyInstance(null, new Class<?>[]{n.type}, n);
    return f.apply(sp, true).onClose(n);
}