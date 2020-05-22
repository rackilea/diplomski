Button button= (Button) findViewById(R.id.standingsButton);
button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,StandingsActivity.class));
    }
});