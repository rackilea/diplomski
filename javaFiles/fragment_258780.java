public class SecondAct extends Activity{

        @Override
            protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
                setContentView(R.layout.secon_act);                
                Toast.maketext(this, ""+Activitymain.input,Toast.LENGTH_LONG).show();
        }