Button button;

@Override
public void onCreate(Bundle savedInstanceState) {

    button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // Here you can edit the view and change activity

            // Change Activity using Intent
            startActivity(new Intent(CurrentActivity.this, SecondActivity.class));
        }
    });

}