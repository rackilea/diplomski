Button activityButton = (Button) findViewById(R.id.Button);
    if (activityButton != null){
        activityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(MainActivity.this, SecondaryActivity.class);
                startIntent.putExtra("com.example.owner.Message","Hello SecondaryActivity");
                startActivity(startIntent);
            }
        });
    }