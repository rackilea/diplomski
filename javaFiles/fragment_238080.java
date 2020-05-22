public class Example extends SuperClass {

Example(int x, int y){
    super(x , y);

    //pick another z implementation here;
    z = x * y ^ x;
}