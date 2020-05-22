public ExpandableListAdapter(Context context, List<String> listDataHeader,
        HashMap<String, List<String>> listChildData, ArrayList<Integer> groupImages) {
    this._context = context;
    this._listDataHeader = listDataHeader;
    this._listDataChild = listChildData;
    this.groupImages = groupImages;
}