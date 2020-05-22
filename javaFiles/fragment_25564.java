public class Main {
    public static void main(String args[]) {
        final String CASE_1 = "case_1";
        final String CASE_2 = "case_2";

        String CASE = "case_1";

        switch(CASE){
            case CASE_1:{
                System.out.println("Case 1 Found");
                break; //Put a break here if you don't want the code to execute for the next case as well.
            }
            case CASE_2:{
                System.out.println("Case 2 Found");
            }
        }
    }
}