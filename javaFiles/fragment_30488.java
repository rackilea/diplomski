public void submitAnswer (View view) {
    if (correctAnswer.isChecked()) {
        SharedPreferences settings = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        if(settings.contains("score"){
            int points = settings.getInt("score", 0);
            points++;

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("score", points);
            editor.commit();
            Toast.makeText(this, "Answer saved : points = " + points, Toast.LENGTH_SHORT).show();
        }
        else{
            Log.e(TAG, "No score yet!");
        }
    } 
    else{
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
    }

    // There is no need to start the MainActivity through a new Intent just call finish();
    finish();
    //... and you return to the Activity that is at the top of the stack.

    //Intent intent = new Intent(Q1.this, MainActivity.class);
    //startActivity(intent);
}