public class QuestionsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.test_layout);

       // false = call showRiskEvaluationDialog() on button NO
       // true  = call showRiskEvaluationDialog() on button YES
       Map<String, Boolean> question_map = new LinkedHashMap<String, Boolean>();
       question_map.put("Have you cut the power?", false);
       question_map.put("Have you not cut the power?", true);
       question_map.put("Do you know your work assignment?", false);
       question_map.put("Don't you know your work assignment?", true);

       // For loop to extract a question and identifier from the Map
       for (Entry<String, Boolean> entry : question_map.entrySet()){
          create_dialog_method(entry.getKey(), entry.getValue());
       }
    }

    /**
     * Method to create a dialogbox with a question and YES, NO buttons
     *
     * @param question_param
     * @param identifier
     */
    public void create_dialog_method(String question_param, final boolean identifier) {
       AlertDialog.Builder alert = new AlertDialog.Builder(this);

       alert.setTitle("Title");
       alert.setMessage(question_param);

       alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int whichButton) {

             if (identifier)
                showRiskEvaluationDialog();
             else
                Toast.makeText(getApplicationContext(), "Saved",
                      Toast.LENGTH_SHORT).show();
          }
       });

       alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int whichButton) {

             if (identifier)
                Toast.makeText(getApplicationContext(), "Saved",
                      Toast.LENGTH_SHORT).show();
             else
                showRiskEvaluationDialog();
          }
       });
       alert.show();
    }

    private void showRiskEvaluationDialog() {}
    }