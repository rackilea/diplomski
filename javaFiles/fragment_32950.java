public class ExampleActivity extends AppCompatActivity {
    public String questionType;

    ....

    public void CreateQuestion(View view) {
         questionType = "";
         questionTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
              switch (checkedId) {
                     case R.id.true_false:
                          questionType = "True/False";
                          break;

                      case R.id.mcqs:
                          questionType = "MCQs";
                          break;
                    }
                }
            });
        }

    ....

}