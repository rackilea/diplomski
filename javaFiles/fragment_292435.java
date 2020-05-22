public deckbuilder_RViewAdapter_List (Context mContext, List<Decklist> mDecklist) {
    this.mDecklist = mDecklist;
    this.mContext = mContext;
}

public void setCards(List<Decklist> mDecklist) {
    this.mDecklist = mDecklist;
    notifyDataSetChanged();
}