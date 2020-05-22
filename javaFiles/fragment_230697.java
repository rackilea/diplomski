public void addListenerOnButton() {

final Context context = this;

button = (Button) findViewById(R.id.buttonstory);

button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(context, Story.class);
            startActivity(intent);

        }

    });

}

public void EXIT(View view) 
        {
            finish();
        }