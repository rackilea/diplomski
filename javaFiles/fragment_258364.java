public void sendMessage(View view){
        ExtractEditText eet = (ExtractEditText) findViewById(R.id.eet);
        String message = eet.getText().toString();
        Intent intent = new Intent(this, GChatReceiveActivity.class);
        intent.putExtra(GChatReceiveActivity.EXTRA_MESSAGE,message);
        String title = getString(R.string.chooser);
     //   Intent chosenIntent = Intent.createChooser(intent,title);
            startActivity(intent);

    }