public class ZeroSum {
    public double sum(double x, float y)
    {
        return 0;
    }
}

public class RealSum  extends ZeroSum{
    public double sum(double x, float y)
    {
        return x+y;
    }
}

public class DrivingSum {
public static void main(String[] args) {
    int x = 10;
    int y = 20;
    // x + y = 30....yay?
    ZeroSum zero= new ZeroSum();
    ZeroSum real= new RealSum();

    System.out.println("Calling ZeroSum " + zero.sum(x,y) ); //here the sum will return zero 
    System.out.println("Calling ZeroSum " + real.sum(x,y) ); //here the sum will return 30 

}