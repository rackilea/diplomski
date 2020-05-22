public class FirstActivity extends Activity {

  private static int counter = 0;      

  private TextView myStringView;
  private static final Random RANDOM = new Random();
  String myString;


  //....my other code


  private static final String[] MYSTRINGS = {
      "string a",
      "string b",
      "string c"
  };

   public void generateString(View v) {

      String myString = MYSTRINGS[counter++];
      if( counter == MYSTRINGS.length ) {
          counter = 0;
      }
      myStringView.setText(myString);

  }
}