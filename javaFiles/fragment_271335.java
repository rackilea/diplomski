public class TestStdErr {
    public static void main(String[] args) {
        try {
            // cause a divide by zero exception 
            int a = 0;
            int b = 2 /a;
         }
         catch(Exception e){
            e.printStackTrace();
        }
    }
}