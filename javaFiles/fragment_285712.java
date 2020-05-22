public void onClick(View v) {
    Intent intent = new Intent(MainActivity.this, NoteEditorActivity.class);
    intent.putExtra("key", "my key");
    intent.putExtra("text", "my text");
    startActivity(intent);
}