anotherButton3.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        // creating the intent
        Intent intent = new Intent(getActivity,    PlayStationActivity.class);
        // starting activity with the created intent
        getActivity.startActivity(intent);
    }
});