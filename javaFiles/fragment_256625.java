object SelfBoundedMainScala extends App {
  class SelfBounded1 extends SelfBounded[SelfBounded1]

  val selfBounded1 = new SelfBounded1()
  println(selfBounded1.testField)
  println(selfBounded1.testMethod().testField)
}