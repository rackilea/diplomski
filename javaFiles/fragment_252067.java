RecyclerView rvContacts = (RecyclerView) findViewById(R.id.exerciseList);

        exerciseBlocks = ExerciseBlock.createContactsList(20);
        ExerciseBlockAdapter adapter = new ExerciseBlockAdapter(this, exerciseBlocks);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));