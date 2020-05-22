@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MyView view = new MyView();


}
public void onClick (View v) {
        switch (view.getId()) {
            case R.id.btn :
                view.isDraw = true;
                break;
        }
    }