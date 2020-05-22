public class ExceptionsDemo {

    public static void main(String[] args) {
        for (int i=args.length;i<10;i++){
            try {
                if(i%2==0){
                    System.out.println("i =" + i);
                    throw new Exception();  // stuff that might throw
                }
            } catch (Exception e) {
                System.err.println("An exception was thrown");
            }
        }
    }
}