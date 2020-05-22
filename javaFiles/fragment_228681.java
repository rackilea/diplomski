public class Logger {

    public static void main(String[] args) {
        String test = "Test";
        println(test);
        println(test, "This is a test");
    }

    public static void println(Object obj, String...vargs) {
        String defaultValue = "initialized";
        if(vargs.length == 0){
            System.out.println(obj.getClass().getName() + " > " + defaultValue);
        }else{
            for(String x: vargs){
                System.out.println(obj.getClass().getName() + " > " + x);
            }
        }
    }
}