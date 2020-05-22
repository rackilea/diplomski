public class Kul extends Activity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.kul);

    final CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
    SharedPreferences settings = getSharedPreferences("pref", 0);
    cb1.setChecked(settings.getBoolean("check", false));
    cb1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
        if(cb1.isChecked())
                {
            SharedPreferences settings = getSharedPreferences("pref", 0);
            settings.edit().putBoolean("check",true).commit();
         } else {
             SharedPreferences settings = getSharedPreferences("pref", 0);
             settings.edit().putBoolean("check",false).commit();
        }
        }
    });
}