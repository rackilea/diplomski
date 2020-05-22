object Foo extends App {
    List(1,2,3,4)
      .map(x => x * 2)
      .filter(x => x % 3 == 0)
      .foreach(print)
}