protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    TextView myTextView = new TextView(this);
    myTextView.setText("Marsha Jackson - (555) 555-5555 - marsha.jackson@email.com - www.jkl.com");
    myTextView.setWidth(100);
    myTextView.setHeight(500);
    //you can keep adding code to change myTextView
    setContentView(myTextView);
}