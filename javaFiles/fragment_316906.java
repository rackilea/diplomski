next.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        Intent myIntent = new Intent(CustomWorkout.this, GetReady.class);
        Bundle b = new Bundle();
        b.putSerializable("all_exercises", Exercises); //arraylist of exercises

        b.putInt("total_rounds", total_rounds); //number of rounds
        b.putInt("total_rest", total_rest); //rest time
        myIntent.putExtra("myData", b);
        startActivity(myIntent);
    }
});