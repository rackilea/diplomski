@Override
    public void onFinish() {
        getSharedPreferences("APP", MODE_PRIVATE).edit().putInt("SOME_IDENTIFIER", score).commit();
        Intent i = new Intent(getApplicationContext(), ScoreActivity.class);
        startActivity(i);
    }