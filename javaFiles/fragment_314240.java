View.OnClickListener startButtonListener = new View.OnClickListener() {
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        this.finish(); 
    }
};