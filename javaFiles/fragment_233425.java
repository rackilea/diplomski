LinearLayoutManager linearLayoutManager
        = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
mRecyclerView.setLayoutManager(linearLayoutManager);
mRecyclerView.setHasFixedSize(true);
mWorkoutAdapter = new WorkoutAdapter(this);
mRecyclerView.setAdapter(mWorkoutAdapter);
Log.i("LOG", "workout list size HERE: " + mWorkoutList.size());
mWorkoutAdapter.setWorkoutData(mWorkoutList);