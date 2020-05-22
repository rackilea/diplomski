// starting of the main java program    
public class RecursiveCall {
    public static void main(String[] args) {
        Boolean result = callingFirstMethod(0);
        System.out.println("Name = "+ result);
    }

// calling callingFirstMethod with a variable with tryCount as 0
    public static Boolean callingFirstMethod(int tryCount){
        final int maxRetries = 3;
        boolean successful = false;

// method call which fails in this method and always return false
        successful = divisonMethods();

// condition which should be tried only 3 times, need to fix that 
        while(tryCount < maxRetries && !successful){
            try {
                Thread.sleep(10000);
            } catch (RuntimeException e){
                System.out.println("Exception Occured with Timer"+ e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
// this is where recursion actually starts and in since it always fails and enter in the infinite loop 
//and trycount value never increases because in the first call itself it will never complete the loop and never increase the value in the trycount to 2.
            successful = divisonMethods();
            tryCount++;
        }
        return successful;
    }

// method which always returns false 
    public static Boolean divisonMethods(){
        if(5>6){
            return true;
        }else{
            return false;
        }
    }
}