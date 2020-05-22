public class MainActivity extends Activity {

Button showGrades;
//GradeCollection grades;
ArrayList<String> grades;
TextView textViewNumericGrade;
TextView textViewLetterGrade;

double numericGrade;
String letterGrade;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //grades = new GradeCollection();

    String e1 = "exam  1  80.00  Exam 1";

    //grades.addGrade(e1);
    grades.add(e1);

    showGrades =  (Button)findViewById(R.id.buttonShowGrades);
    showGrades.setOnClickListener( new OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, GradeListActivity.class);
            intent.putExtra("grades", grades);
            startActivity(intent);
            }
        });

}