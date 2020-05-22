interface ItfA { Number propA(); };
interface ItfB { Number propB(); };

class Main<T extends ItfA & ItfB> {

  T theT;

  public void setT(T newT) {
     theT = newT;
  }

  public void doStuffWithT() {
     System.err.println(theT.propA());
     System.err.println(theT.propB());
  }

}