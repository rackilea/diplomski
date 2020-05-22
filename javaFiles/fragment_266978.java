@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {

    ...
    ...

    //Create VocCards and add to List
    mVocCardList = new ArrayList<>(3);

    for (int i = 0; i < 3; i++) {
        mVocCardList.add(new VocCard(voc_f[i], voc_n[i]));
    }

    Button startBtn = (Button) findViewById(R.id.button);
    startBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, PracticeActivity.class);
            intent.putParcelableArrayListExtra("voc1", (ArrayList<? extends Parcelable>) mVocCardList);
            startActivity(intent);
        }
    });
}