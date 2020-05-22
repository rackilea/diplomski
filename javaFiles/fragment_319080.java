class Main
{

 public static void main(String args[ ])
 {
    double r;
    double h;

    Cone cone = new Cone();

    for (double i = 0; i < 10; i++)
    {
               // r and h are not set yet
               r = h = i;  // maybe?
               cone.setRadius(r);
               cone.setHeight(h);

               System.out.printf("Volume =  %d\n", cone.volume( ));
    }
 }
}