private deckbuilder_RViewAdapter_List mCardListAdapter;

public deckbuilder_RViewAdapter_Card(FragmentActivity mContext, List<Cards> mData, deckbuilder_RViewAdapter_List mCardListAdapter) {
    this.mData = mData;
    this.mContext = mContext;
    this.mCardListAdapter = mCardListAdapter;
}

public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
    fab_deckbuilder_add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            List<Decklist> listCards = new ArrayList<>();
            listCards.add(new Decklist( ... );

            mCardListAdapter.setCards(listCards);
        }
    });
}