public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private Class[] arrayClass= {A.class, B.class,C.class}; // classes you want to open
      private String[] buttonNames= {"A", "B", "C"};  // button texts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayout container = (LinearLayout)findViewId(R.id.container);
        // adding buttons in container
        for(int index=0;index<arrayClass.length && arrayClass.lenght == buttonNames.length; index++){
            Button button = new Button(this);
            button.setText(buttonNames[index]);
            button.setOnClickListener(this)
            button.setTag(arrayClass[index]);
            container.addView(button);
        }
    }

   @Override
    public void onClick(View v) {

    if(v.getTag() instanceOf Class ){
      // will open your particular activity
      startActivity(new Intent(this,(Class)v.getTag()));
    }

   }