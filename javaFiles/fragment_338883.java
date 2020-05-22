blueTheme.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        //NOTE: Where I've put MainActivity that should actually be the name
        //      of whatever activity this code is nested in
        Intent intent = new Intent(MainActivity.this, OtherActivity.class); //use your real class name
        intent.putExtra(OtherActivity.EXTRA_COLOR, Color.BLUE);
        startActivity(intent);

    }

});