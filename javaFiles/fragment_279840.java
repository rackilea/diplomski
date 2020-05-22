public class CalcInterest{

  public static double getInterest(double rate, int time, double principal){
    double multiplier = Math.pow(1.0 + rate/100.0, time) - 1.0;
    return multiplier * principal;
  }

  public static void main(String[] args){
    int months[] = {2, 5, 10, 500};
    for(int mon : months)
        System.out.println("Interest at " + mon + " months is " + getInterest(2.65,mon,1000));

  }

}