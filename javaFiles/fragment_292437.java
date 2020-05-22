@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    // ... after inflate view

    rvCards = view.findViewById(R.id.rv_deckbuilder_cards)
    rvList = view.findViewById(R.id.rv_deckbuilder_list)

    deckbuilder_RViewAdapter_List listAdapter = new deckbuilder_RViewAdapter_List(..)
    deckbuilder_RViewAdapter_Card cardAdapter = new deckbuilder_RViewAdapter_Card(.., listAdapter)
    rvCards.setAdapter(cardAdapter);
    rvList.setAdapter(listAdapter);

    // ...
}