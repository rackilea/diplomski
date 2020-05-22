public void deleteGoal(int position) {
        Goal g = goalsList.get(position); //go to goal in goallist
        db.deleteGoalFromDb(g.idGoal); //deletes the goal from the database, using its id stored in the object
        //Below code will refresh the screen
        ListView lview = (ListView) findViewById(R.id.GoalsTable);
        populateList();
        ListViewAdapter adapter = new ListViewAdapter(this, list);
        lview.setAdapter(adapter);
    }