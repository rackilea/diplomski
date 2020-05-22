TextView feedTitle;
TextView feedDescribtion;
ListView listView;

public View onCreateView(...) {
    ...
    feedTitle = (TextView) rootView.findViewById(R.id.feedtitle);
    feedDescribtion = (TextView) rootView.findViewById(R.id.feeddescribtion);
    listView = (ListView) rootView.findViewById(android.R.id.list);
    ...
}