@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final EditText et = (EditText) (findViewById(R.id.editText));
    final com.example.imgintext.DrawText imgView = (com.example.imgintext.DrawText) findViewById(R.id.imageView1);
    et.setVisibility(View.INVISIBLE);
    et.setOnKeyListener(new OnKeyListener() {

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {

            imgView.setTexto(et.getText().toString());

            return false;
        }
    });

    imgView.setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            imgView.setXY(event.getX(), event.getY());
            et.requestFocus();
            return false;
        }
    });
}