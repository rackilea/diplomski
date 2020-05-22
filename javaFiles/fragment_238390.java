public class rps extends AppCompatActivity {
    //int userChoice, pcChoice, winner, userWinCount, pcWinCount;
    ImageButton choiceRock;
    ImageButton choicePaper;
    ImageButton choiceScissors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);

        choiceRock = (ImageButton) findViewById(R.id.rps_rock);
        choicePaper = (ImageButton) findViewById(R.id.rps_paper);
        choiceScissors = (ImageButton) findViewById(R.id.rps_scissors);

        choiceRock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               //choiceRock.setImageResource(R.drawable.rps_blue_rock);
               //userChoice = 1;
               setPcChoice();
               //setWinner();
            }
        });

        choicePaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               //choicePaper.setImageResource(R.drawable.rps_blue_paper);
               //userChoice = 2;
               setPcChoice();
               //setWinner();
            }
        });

        choiceScissors.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               //choiceScissors.setImageResource(R.drawable.rps_blue_scissors);
               //userChoice = 3;
               setPcChoice();
               //setWinner();
            }
        });

        //userWinCount = 0;
        //pcWinCount = 0;
    }

    public void setPcChoice() {
        int randNum;
        Random randInt = new Random();
        randNum = randInt.nextInt(3) + 1;
        //pcChoice = randNum;
    }
}