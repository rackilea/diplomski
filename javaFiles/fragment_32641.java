public void insert( View v ) {
String description = editDescription.getText( ).toString( );
String weightString = editWeight.getText( ).toString( );
String repsString = editReps.getText( ).toString( );

try {
    Workouts workout = new Workouts(); // add this line
    int weight = Integer.parseInt( weightString);
    int reps = Integer.parseInt( repsString);

    workout.setId(0);
    workout.setDescription(description);
    workout.setWeight(weight);
    workout.setReps(reps);
    myDb.insert( workout);
    Toast.makeText( this, "Workout added", Toast.LENGTH_SHORT ).show();
   } catch( NumberFormatException nfe ) {
        Toast.makeText( this, "Number error", Toast.LENGTH_LONG ).show( );
   }
}