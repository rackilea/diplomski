public class ActivityB extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activityb);

    Intent svc = new Intent(this, BackgroundSound.class);
    startService(svc);

    msg.show();

}

}