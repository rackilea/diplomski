Intent intent;
String actu_ip;

@Override
public void onCreate(Bundle savedInstanceState) {
    ....
    Intent intent = getIntent();
    String actu_ip = intent.getStringExtra(IPEntry.ACTUALSMARTIP);
    ....
}