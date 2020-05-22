public void locateFromString(View view) {
    hideSoftKeyboard(view);
    TextView tv = (TextView) findViewById(R.id.editText1);
    String searchString = tv.getText().toString();

    ArrayList<String> thePlaces = new ArrayList<>();
    thePlaces.add("Thirsty Monk");
    thePlaces.add("Cocolino");
    thePlaces.add("The Melting Pot");
    thePlaces.add("De Danu");
    thePlaces.add("Carciuma");
    thePlaces.add("Boca");
    thePlaces.add("Bar Acasa");


    if (thePlaces.contains(searchString)) {
        //call goToLocation
    } else {
        Toast.makeText(this, "There is no " + searchString + " subscribed to this app!", Toast.LENGTH_LONG).show();
    }
}