package CatchBlock;
public class DevideByZerooException extends Exception {

    DevideByZerooException() {
        super("Error: Dividing by Zero is impossible");
    }

    DevideByZerooException(String message){
        super(message);
    }
}