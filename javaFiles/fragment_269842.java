public class MyActivity extends Activity implements View.onLongClickListener {

   View myView = null;


   public void onCreate(Bundle state) {
      super.onCreate(state);
      setContentView(R.layout.my_activity);
      myView = findViewById(r.id.my_view);
      myView.setOnLongClickListener(this);
   }

   @Override
   public void onLongClick(View v) {
    //long clicked
   }

}