createEventButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        db.insertData(
            titleTextView.toString(),
            timePicker.getCurrentHour().toString(),
            timePicker.getCurrentMinute().toString(),
            entryEvent.getText().toString(),
            entryLocation.getText().toString(),
            entryCrew.getText().toString()
        );

        Toast.makeText(EventCreateActivity.this, "I'll keep that in mind.", Toast.LENGTH_LONG).show();

        setResult(RESULT_OK);
        finish();
    }
});