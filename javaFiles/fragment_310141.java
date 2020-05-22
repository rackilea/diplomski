public abstract class B implements A {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

object AFactory {
  def getA: A = new B {
    override def getSomething: String = "test"
  }
}