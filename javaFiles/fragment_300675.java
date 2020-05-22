public class MainActivity extends AppCompatActivity {

    ArrayList<String []> al = new ArrayList<>(); //declare it here


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleArrayListofArray ();

    }

    public void exampleArrayListofArray () {

        al.add(new String[] {"AB","YZ","12"});
        al.add(new String[] {"CD","WX", "34"});
        al.add(new String[] {"EF","UV", "56"});
        al.add(new String[] {"GH","ST", "78"});
        al.add(new String[]{"IJ", "QR", "91"});
        al.add(new String[]{"KL", "OP", "10"});
        displayArrayListofArray();
    }

    public void displayArrayListofArray() {

        for (String [] row : al)
            for (int column = 0; column <= 2 ; column ++){
                System.out.println("Value at Index Row " + al.indexOf(row) +
                        " Column " + column + " is " + (row)[column]);
            }
        EditText userField = (EditText) findViewById(R.id.user_field);
        String lookUpString = userField.getText().toString();
        lookUpMethod(lookUpString);

    }

    public void lookUpMethod(String lookUpString) {
        boolean isStringFound = false;
        for (String[] row : al) {
            for (int column = 0; column <= 2; column++) {
                if (al.get(al.indexOf(row))[column].equals(lookUpString)) {
                    System.out.println("Index of '" + lookUpString + "': " + al.indexOf(row) + column);
                    isStringFound = true;
                }
            }
        }
        if (!isStringFound) {
            System.out.println("Search string '" + lookUpString + "' does not exist.");
        }
    }

    public void calculate(View view){
        EditText userField = (EditText) findViewById(R.id.user_field);
        String lookUpString = userField.getText().toString();
        System.out.println("user input : " + lookUpString);

        lookUpMethod(lookUpString);

    }
}