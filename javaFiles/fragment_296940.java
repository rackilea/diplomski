public class MainActivity extends Activity {

    //Declare a class variable to use in this class
    public Double myNumber1;
    public Double myNumber2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            myNumber1 = 250;
            myNumber2 = 10;

            //mySum is only available for use within this method
            Double mySum = addition1 (myNumber1, myNumber2);

    }
    private double addition1 (double myRanNumber1, double myRanNumber2) {
       return myRanNumber1 + myRanNumber2;
    }
}