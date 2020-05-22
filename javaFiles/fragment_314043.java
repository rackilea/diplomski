reminderRecyclerView = (RecyclerView) findViewById(R.id.my_reminder_recycler_view);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            reminderRecyclerView.setHasFixedSize(true);

            reminderEvents();
            // use a linear layout manager
            reminderLayoutManager = new LinearLayoutManager(this);
            reminderRecyclerView.setLayoutManager(reminderLayoutManager);


            reminderAdapter = new RemindersAdapter(reminderEventsList);
            reminderRecyclerView.setAdapter(reminderAdapter);