public class Task1Activity extends AppCompatActivity {

    int attempts = 0;
    final int maxAttempts = 3;
    Random randGen = new Random();
    int ranNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task1_layout);

        final TextView textResponse = (TextView) findViewById(R.id.txtResponse);
        final TextView guessText = (TextView) findViewById(R.id.txtAnswer);
        final EditText userGuess = (EditText) findViewById(R.id.etNumber);

        Button pressMe = (Button) findViewById(R.id.btnGuess);

        randGen = new Random();
        // Generate number once
        ranNum = randGen.nextInt(5);


        // When the button is clicked, it shows the text assigned to the txtResponse TextView box
        pressMe.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           if(++attempts>maxAttempts){
                               //anything when more then maxAttempts needed
                           }else{
                               String randText = "";
                               //Random randGen = new Random();  not needed anymore
                               //int ranNum = randGen.nextInt(5);  will generate new random number every click
                               int userNumber = Integer.parseInt(userGuess.getText().toString());


                               if (userNumber > 19) {  //20???
                                   guessText.setText("Please guess between 0 and 20");
                               } else if (userNumber < ranNum) {
                                   guessText.setText("Your answer is too low. Guess again!");
                                   guessText.setBackgroundColor(Color.RED);
                               } else if (userNumber > ranNum) {
                                   guessText.setText("Your answer is too high.  Guess again!");
                                   guessText.setBackgroundColor(Color.RED);
                               } else if (userNumber == ranNum) {
                                   ranNum = randGen.nextInt(5);
                                   guessText.setText("You did it!");
                                   guessText.setBackgroundColor(Color.WHITE);
                               }

                               randText = Integer.toString(ranNum);
                               textResponse.setText("");

                               userGuess.setText("");
                           }
                       }
                   }
        );

}