public List<WorkoutItem> getDataForListView()
{
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String workoutTime = prefs.getString("Workout Time", "");

    List<WorkoutItem> workoutsList = new ArrayList<WorkoutItem>();

    for(int i = 0; i < (workoutsList.size() + 1); i++)
    {
        WorkoutItem workout = new WorkoutItem();
        workout.workoutNum = "Workout " + (i+1);
        workout.time = workoutTime;

        workoutsList.add(workout);
    }

    return workoutsList;
}