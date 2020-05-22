public class SuccessTest {
public static void main(String[] args) {
    int success = 0;
    updateSuccess(success);
    System.out.println(success); //will print 0
}

private static void updateSuccess(int success) {
    //changing value of success here will not reflect in main method 
    success=2;
    System.out.println(success);//will print 2
}
}