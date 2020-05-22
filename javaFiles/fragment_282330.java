public class Main {
  public static void main(String... args) throws IOException {
    ASMifierClassVisitor cv = new ASMifierClassVisitor(new PrintWriter(System.out));
    ClassReader cr = new ClassReader("X");
    cr.accept(cv, 0);
  }
}

class X {
  {
    System.out.println("Inside class "+X.class);
  }
}