private int num;

public NewClass1( int n)
{

    n=num;
    System.out.println("Get Num: "+num);

}
   public int getNum() {
      return num;
   }

   public void Message() {
       System.out.println(num);
   }

    }

 and your main class will look like this

public class NewClass2
 {

    public static void main(String[] args ) {
    NewClass1 obj = new NewClass1(9000);// your valur
    obj.Message();
    }
}