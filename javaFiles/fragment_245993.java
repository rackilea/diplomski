public class Test{
     class MyTriangle 
     {
      int side1,side2,side3;
      public   MyTriangle()
      {
        this.side1 = 3;
        this.side2 = 4;
        this.side3 = 5;
      } 

    }
public static void main(String[] args) 
    {   
     MyTriangle h1 = new Test(). new MyTriangle();   // Fix is here**   
     }
}

interface Triangle{}