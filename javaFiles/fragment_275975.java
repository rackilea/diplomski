@Override
public void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);// Add THIS LINE

    setContentView(R.layout.app);

    TextView tv = (TextView) this.findViewById(R.id.thetext);
    tv.setText("App View yo!?\n");
}