import java.util.Scanner;
class A{

    public static int []PriorGreen = new int[6];
        public static int []AfterGreen = new int[6];
        public static String []month = {"Jan","Feb","Mar","April","May","June"};

    static void PriorG()
{
    System.out.println(" Enter Cost for Prior Green Month's Below !!!");
    Scanner in = new Scanner(System.in);
    for(int i=0;i<6;i++){
          System.out.println("  Please enter cost for "+month[i]);
          PriorGreen[i]=in.nextInt();

        }
}

static void AfterG()
{
    System.out.println(" Enter Cost for After Green Month's Below !!!");
        Scanner in = new Scanner(System.in);
    for(int i=0;i<6;i++){
          System.out.println("  Please enter cost for "+month[i]);
          AfterGreen[i]=in.nextInt();

        }
}
static void energySaved()
{
    for(int i=0;i<6;i++){

          System.out.println(" Energy saved in "+month[i]+" is "+(PriorGreen[i]-AfterGreen[i]));


        }
}
static void display()
{
              System.out.println("Prior Green       "+"After Green    "+ "Savings");
    for(int i=0;i<6;i++){

          System.out.println(PriorGreen[i]+"                  "+AfterGreen[i]+"                  "+(PriorGreen[i]-AfterGreen[i]));


        }
}

    public static void main(String []args)
    {

        PriorG();
        AfterG();
        energySaved();

        display();      

    }


}