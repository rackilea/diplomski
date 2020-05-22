// initialise the array with size 3
CardData cardData[] = new CardData[3];

// start adding elements now
// insert first object by checking flag "a"
if (a) {
    cardData[0] = new CardData("Bread", R.drawable.bread);
}
else {
    cardData[0] = new CardData("Bread", R.drawable.bread, R.drawable.indicator);
}

// insert second object by checking flag "b"
if (b) {
    cardData[1] = new CardData("Dairy", R.drawable.dairy);
}
else {
    cardData[1] = new CardData("Dairy", R.drawable.dairy, R.drawable.indicator);
}

// and so on...