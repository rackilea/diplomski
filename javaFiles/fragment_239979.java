@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    LinearLayout root = (LinearLayout) findViewById(R.id.master);
    EditText t[][] = new EditText[10][10];
    LinearLayout.LayoutParams dim = new LinearLayout.LayoutParams(LinearLayout.LayoutParams
            .WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    for (int i=0;i<9;i++){
        for (int j=0;j<9;j++){
            t[i][j]=new EditText(this);
            t[i][j].setLayoutParams(dim);
            t[i][j].setHint("Hello World , EditText[" + i + "]" + "[" + j + "]");
            root.addView(t[i][j]);
        }
    }
}