note.setKey(intent.getStringExtra("key"));
note.setText(intent.getStringExtra("text"));

EditText edit = (EditText) findViewById(R.id.noteText);
edit.setText(note.getText());
edit.setSelection(note.getText().length());