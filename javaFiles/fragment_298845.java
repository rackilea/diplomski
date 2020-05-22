@Override
 public void onCreate(Bundle bundle) {
     super.onCreate(bundle);
     new Handler().post(new Runnable() {
         @Override
         public void run() {
            Intent intent = new Intent(LaunchActivity.this, ScheduleActivity.class);
            startActivity(intent);
            finish();
         }
     });
 }