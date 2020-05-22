public class Cerchio{

  float r;
  float area;
  float cfr;
  final double pi = 3.14;

  public static void main(String[] args){
    System.out.println("CIRCLE PROGRAM\n");

    Cerchio cerchio = new Cerchio();
    cerchio.r = 5;
    cerchio.c_cfr();
    cerchio.c_area();
    System.out.ptintln("The cir is: " + cerchio.cfr);
    System.out.println("The area is: " + cerchio.area);
  }

  float c_cfr(){
    cfr =(float)(2 * pi * r); //casting
    return cfr;
  }

  float c_area(){
    area = (float)(pi * (r*r));
    return area;
  }

}