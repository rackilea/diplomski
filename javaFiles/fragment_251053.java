// Populate Method
    private void populateList() {
        List<String> values = new ArrayList<String>();

        for(Note note : notes) {

            values.add(note.getTitle());
        }

        CustomListAdapter CustomAdapter = new CustomListAdapter(this, values);

        notesListView.setAdapter(CustomAdapter);
    }