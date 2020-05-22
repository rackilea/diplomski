new AlertDialog.Builder(YourActtivity.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Pop Up!")
            .setMessage("Ready to delete this task?")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences myPref = getSharedPreferences("com.example.jackson.collegeplanner", Context.MODE_PRIVATE);
                    Set<String> notesSet = new HashSet<String>(myPref.getStringSet("NN", null));
                    ListView listView = (ListView) findViewById(R.id.listView);
                    notesSet.remove(i);
                    notes.clear();
                    notes.addAll(notesSet);
                    myPref.edit().putStringSet("NN", notesSet).apply();
                    ArrayAdapter arrayAdapter = new ArrayAdapter(YourActtivity.this, android.R.layout.simple_list_item_1, notes);
                    listView.setAdapter(arrayAdapter);
                    Log.i("TEST", "notesSet didn't return null!");
                }
            })
            .show();