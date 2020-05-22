public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.card_game);

    card = (ImageView) findViewById(R.id.card);

    card.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            card.setImageResource(R.drawable.backside);
            card.postDelayed(new Runnable() {
                @Override
                public void run() {
                    int rdmCard = randomCard();
                    card.setImageResource(rdmCard);
                }
            },100);

        }
    });
}

public int randomCard() {
    TypedArray cardsArray = getResources().obtainTypedArray(R.array.cardFaces);
    int randomNumber =  (int)(Math.random() * ((100 - 0) + 1));
    int card = cardsArray.getResourceId(randomNumber, randomNumber);
    cardsArray.recycle();
    return card;
}