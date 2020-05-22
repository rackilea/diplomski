btn = (Button)findViewById(R.id.firstButton);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String level = view.getTag().toString();
        Log.d(TAG, "Level Selected : " + level);
        // Apply the rest of the logic
    }
});