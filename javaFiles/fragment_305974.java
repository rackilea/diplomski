class Outer
{
     int outer = 0;
     class Inner
     {
          int inner = Outer.this.outer; //(or just outer as it is not shadowed)
          Inner() {
              inner = 3; //or whatever, even outer = 3
          }
     }
}