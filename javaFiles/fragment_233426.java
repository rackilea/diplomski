if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()){
                        OtherWorkout workout = document.toObject(OtherWorkout.class);
                        mWorkoutList.add(workout);
                        Log.i("LOG", "workout list size: " + mWorkoutList.size());
                    }mWorkoutAdapter.notifyDatasetChanged();

                }