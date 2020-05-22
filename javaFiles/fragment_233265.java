public void opendiagnosis() {
    // for all pairs: one of each pair has to be checked
    boolean shouldStartNextActivity = (radioButton.isChecked() || radioButton2.isChecked())
            && (radioButton3.isChecked() || radioButton4.isChecked());


    if (shouldStartNextActivity){
        Intent intent = new Intent(this, answers.class);
        startActivity(intent);
    } else{
        Toast.makeText(getBaseContext(), "Please answer all the questions for an accurate diagnosis", Toast.LENGTH_LONG).show();
    }
}