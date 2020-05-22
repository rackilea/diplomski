private void updateScore ( int point){
        mScoreView.setText("" + mScore);

        SharedPreferences sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        Editor editor = sharedpreferences.edit();
        editor.putInt("currentscore", mScore);
        editor.commit();
}