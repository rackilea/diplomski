public class MainActivity extends Activity implements OnClickListener{


Button btn ;
RadioGroup selectionGroup;
public static int score = 0;//to access it in other class as well to ++ or --
boolean answerAttempt = false; //to penalize player changing the answer      ;)

@Override
protected void onCreate(Bundle savedInstanceState)  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btn = (Button) findViewById(R.id.button1);
    btn.setOnClickListener(this);
    selectionGroup = (RadioGroup) findViewById(R.id.rad_btn_group1);
    selectionGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // TODO Auto-generated method stub
            //because we know radiobutton3 is contains the right answer :)
            if(answerAttempt)
            {
                score -= 2;
            }
            else if (R.id.radioButton3 == checkedId && !answerAttempt)
            {
                ++score;
                answerAttempt = true; //meaning first attempt is made by the player
            }
            else
            {
                --score;
                answerAttempt = true; //meaning first attempt is made by the player
            }

        }
    });
}



@Override
public void onClick(View v) {
    // TODO Auto-generated method stub


switch(v.getId())//this is the id of the button clicked (in our case submit button)
    {
    case R.id.button1://this is the id of the submit button in xml
        //start another activity from here for next question on another activity :)

        break;
    }

}
}