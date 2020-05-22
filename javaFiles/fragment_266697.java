@Override
protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dobeyti);
   final TextView tView;
Button mButton;

tView = (TextView)findViewById(R.id.textView1);
mButton = (Button)findViewById(R.id.button);
assert mButton != null;
mButton.setOnClickListener(new    View.OnClickListener() {

    int num = 0;
    @Override
    public void onClick(View v) {

        num++;


       tView.setText(Integer.toString(num));
    }
});

}
}