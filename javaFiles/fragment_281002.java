public class RoundRobinCollector {
    public static void main(String[] args) {
        Observable<Object> o1 = Observable.just("1", "2", "3", "4");
        Observable<Object> o2 = Observable.just("a", "b", "c");
        Observable<Object> o3 = Observable.just("@", "#");

        Object tag = new Object();
        Observable<Object> otag = Observable.just(tag);

        Observable<Object> p1 = o1.concatWith(otag.repeat());
        Observable<Object> p2 = o2.concatWith(otag.repeat());
        Observable<Object> p3 = o3.concatWith(otag.repeat());

        Observable.zip(p1, p2, p3, (a, b, c) -> {
            List<Object> list = new ArrayList<>();
            if (a != tag) {
                list.add(a);
            }
            if (b != tag) {
                list.add(b);
            }
            if (c != tag) {
                list.add(c);
            }
            return list;
        })
        .takeWhile(list -> !list.isEmpty())
        .concatMapIterable(v -> v)
        .toList()
        .subscribe(System.out::println)
        ;
    }
}