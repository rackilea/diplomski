static final int FIRST_INTENT = 1;
static final int SECOND_INTENT = 2;

@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

Button mainbutton = (Button)findViewById(R.id.mainbutton);

mainbutton.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View view)
    {
        Intent intent1 = new Intent(MainActivity.this,Child.class);
        intent1.putExtra("Prompt", "Enter first data set");
        startActivityForResult(intent1,FIRST_INTENT);
    }

});
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == FIRST_INTENT) {
        if (resultCode == RESULT_OK) {
            Intent intent2 = new Intent(MainActivity.this,Child.class);
            intent2.putExtra("Prompt", "Enter second data set");
            startActivityForResult(intent2,SECOND_INTENT);
        }
    }
}