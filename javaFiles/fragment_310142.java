public abstract class B implements A {
    @Override
    public int compareTo(Object o) {
        return compareToBridge(o);
    }

    protected abstract int compareToBridge(Object o);
}

object AFactory {
  def getA: A = new B {
    override def getSomething: String = "test"

    override def compareToBridge(o: Any): Int = ???
  }
}