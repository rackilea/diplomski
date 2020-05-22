interface ItfA { Number propA(); };
interface ItfB { Number propB(); };

class Main {

  private <T extends ItfA & ItfB> T getT() {
     return null;
  }

  private <TT extends ItfA & ItfB> void doStuffWithT() {
     TT theT = getT();
     System.err.println(theT.propA());
     System.err.println(theT.propB());
  }

}