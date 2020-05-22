final TextView averageView = findViewById(R.id.averageView);
final String averageText = getString(R.string.average);
final Button calculateButton = findViewById(R.id.calculateAverageButton);

calaculateButton.setOnClickListener(new  View.onClickListener() {
 @SupressLint("SetTextI18n")
 public void onClick(View v) { 

int grade = {Integer.parseInt(((EditText) 
findViewById(R.id.grade1)).getText().toString());

int weight = {Integer.parseInt(((EditText)  
findViewById(R.id.weight1)).getText().toString());

double sum = grade * weight

double average = sum / weight


averageView.setText(averageText +" "+ average);