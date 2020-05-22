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
       if (tryCount < maxRetries && !successful){            
            successful = callingFirstMethod( tryCount + 1);
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