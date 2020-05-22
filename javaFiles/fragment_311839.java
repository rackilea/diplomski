Fn1<Integer,String> formatFn = new Fn1<Integer,String>() {
  public String apply(Integer x) {
    return format(x);
  }
};

List<Integer> xs = Arrays.asList(1,2,3,4);
IteratorFunctor<Integer> fi = IteratorFunctor.apply(xs.iterator());
IteratorFunctor<String> fs = fi.map(formatFn);
Iterator<String> ss = fs.i;

int i = 0;
while (ss.hasNext()) {
  System.out.println(i + ": " + ss.next());
  i = i + 1;
}

// Prints the following to stdout:
//
// 0: one
// 1: two
// 2: big
// 3: big
//