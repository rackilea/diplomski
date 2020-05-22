View view = mInflater.inflate(R.layout.list_load_more_row, null);

TextView footer = (TextView) view.findViewById(R.id.loadMore);

getListView().addFooterView(footer);

setListAdapter(ListViewHelper.getAdapterForContentList(mContent, this));