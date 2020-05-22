@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {

    ...
    ...

    final ArrayList<VocCard> vocCardList = getIntent().getParcelableArrayListExtra("voc1");

    final VocCard card = vocCardList.get(2);
    String test = card.getVocForeign();

    ... 
    ...

}