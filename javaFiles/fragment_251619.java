startAppBtn = (Button) findViewById(R.id.button1);

    startAppBtn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
                        Intent intent = new Intent(this, SecondActivity.class);
    Bundle bundle = new Bundle();
    bundle.putString("websiteURL", "file:///android_asset/My.html");
    intent.putExtras(bundle);
    startActivity(intent);
        }
    });