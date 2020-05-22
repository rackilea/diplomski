public class Program
{
  public static void main(String[] args) {
     Parser p = new MyCommandlineParser();
     Options op = p.Parse(args);

     Solver solver = new Solver();
     s.SolveVariables(op.getTimesToSolve());
     System.out.println("Done.  OOP is about design not programming");
  }
}