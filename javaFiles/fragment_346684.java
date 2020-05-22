public CustomBaseAdapter(Context context, List<RowItem> items) {
        this.context = context;
        this.rowItems = items;

        arrayList = new ArrayList<String>();
        for(int i = 0; i < rowItems.size(); i++)
        {
            RowItem rowItem = (RowItem) getItem(position);
            arrayList.add(rowItem.getTitle());
        }
    }