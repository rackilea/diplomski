public class Test1 {     

    public static void main( String [] args) 
    { 
        MyTriangle h1 = new MyTriangle();     
    } 
} 
class MyTriangle implements Triangle{
    int side1;
    int side2;
    int side3;

    public MyTriangle(){
        this.side1 = 1;
        this.side2 = 2;
        this.side3 = 3;
    }
}
interface Triangle{}