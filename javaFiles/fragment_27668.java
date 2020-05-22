private Switch switchConv;
@Override
protected void onCreate(Bundle bundle) {
   super.onCreate(bundle);
setContentView(R.layout.activity_main);
switchConv = (Switch)this.findViewById(R.id.switch1);

SharedPreferences pref = this.getSharedPreferences("MyPref", MODE_PRIVATE);
switchCon.setChecked(pref.getBoolean("vibeRemember", true));
}