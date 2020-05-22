//I hope this will help you
public class TESTActivity extends AppCompatActivity implements View.OnClickListener{

Button buttonObjectChoice1;
Button buttonObjectChoice2;
Button buttonObjectChoice3;
TextView textObjectPartA;
TextView textObjectPartB;
TextView textObjectScore;
TextView textObjectLevel;
TextView textObjectHighScoresScores;

int correctAnswer;
int currentScore = 0;
int currentLevel = 1;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    textObjectPartA = (TextView) findViewById(R.id.textPartA);
    textObjectPartB = (TextView) findViewById(R.id.textPartB);
    //textObjectHighScoresScores = (TextView) findViewById(R.id.textScore);

    textObjectScore = (TextView) findViewById(R.id.textScore);
    textObjectLevel = (TextView) findViewById(R.id.textLevel);

    buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
    buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
    buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);

    buttonObjectChoice1.setOnClickListener(this);
    buttonObjectChoice2.setOnClickListener(this);
    buttonObjectChoice3.setOnClickListener(this);

    setQuestion();
}//onCreate ends here



@Override
public void onClick(View view) {
    //Declaring a new int which will be used in all the cases
    int answerGiven = 0;
    switch (view.getId()) {

        //Initializes a new int with a value for buttonObjectChoice1,2,3
        case R.id.buttonChoice1:
            answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
            break;

        case R.id.buttonChoice2:
            answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
            break;

        case R.id.buttonChoice3:
            answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
            break;
    }//switch ends here

    updateScoreAndLevel(answerGiven);
    setQuestion();

}//onClick ends here



void setQuestion() {
    //Generates the parts of the question
    int numberRange = currentLevel * 3;
    Random randInt = new Random();

    int partA = randInt.nextInt(numberRange);
    partA++;//To avoid a zero value

    int partB = randInt.nextInt(numberRange);
    partB++;//To avoid a zero value

    correctAnswer = partA * partB;
    int wrongAnswer1 = correctAnswer - 2;
    int wrongAnswer2 = correctAnswer + 2;

    textObjectPartA.setText("" + partA);
    textObjectPartB.setText("" + partB);

    //Gives a number between 0 and 2 for the multi choice buttons
    int buttonLayout = randInt.nextInt(3);
    switch (buttonLayout) {
        case 0:
            buttonObjectChoice1.setText("" + correctAnswer);
            buttonObjectChoice2.setText("" + wrongAnswer1);
            buttonObjectChoice3.setText("" + wrongAnswer2);
            break;

        case 1:
            buttonObjectChoice2.setText("" + correctAnswer);
            buttonObjectChoice3.setText("" + wrongAnswer1);
            buttonObjectChoice1.setText("" + wrongAnswer2);
            break;

        case 2:
            buttonObjectChoice3.setText("" + correctAnswer);
            buttonObjectChoice1.setText("" + wrongAnswer1);
            buttonObjectChoice2.setText("" + wrongAnswer2);
            break;

    }//switch ends here
}//setQuestion ends here


//Updates the Score & Level for the player
void updateScoreAndLevel(int answerGiven){
    if(isCorrect(answerGiven)){
        for(int i = 1; i <= currentLevel; i++){
            currentScore = currentScore + i;
        }
        currentLevel++;
    }else{
        currentScore = 0;
        currentLevel = 1;
    }
    //Updates the Score & Level TextViews
    textObjectScore.setText("Score: " + currentScore);
    textObjectLevel.setText("Level: " + currentLevel);

    SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    int storedHighScore = sharedPreferences.getInt("highScore",0);
    if (currentScore>storedHighScore){
        editor.putInt("highScore",currentScore);
        editor.commit();
    }
}//updateScoreAndLevel ends here


//Sends a toast message to the player - if right = Correct!, if wrong = Wrong! :(.
boolean isCorrect(int answerGiven){
    boolean correctTrueOrFalse;
    if(answerGiven == correctAnswer){

        Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
        correctTrueOrFalse=true;
    }else{
        Toast.makeText(getApplicationContext(), "Wrong! :(", Toast.LENGTH_LONG).show();
        correctTrueOrFalse=false;
        Intent intent = new Intent(this,HighScoreActivity.class);
        startActivity(intent);
    }
    return correctTrueOrFalse;
}//isCorrect ends here



}//TESTActivity ends here