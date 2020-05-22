import com.somewhere.SomethingException;
    public class JavaApplication1 {
                public static void main(String[] args) {
                    try{
                        int x=5;
                        //  if(x<10){} // you don't need this line.
                        x = x/0;  // The condition to jump into catch scope.
                    }catch(ArithmeticException e){  // You can define your own exception here.
                        throw new SomethingException("There is an exception.All is false");
                    }
                }
            }