View.OnCliskListener theListener = new View.OnClickListener() {
    public void onClick(View buttonClicked) {
        String textOfTheButtonClicked = map.get(buttonClicked);
        if (!textOfTheButtonClicked.equals(theTextChosenRandomly)) {
            // do what you want here
        }
    }
};