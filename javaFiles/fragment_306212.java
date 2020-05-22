noteViewModel.getAllnotes().observe(this, new Observer<List<Note>>() {
        @Override
        public void onChanged(List<Note> notes) {
            adapter = new NoteAdapter(notes);
            adapter.SetOnItemClickListener(this);
            rv.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    });