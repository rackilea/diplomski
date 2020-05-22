public ArrayList<IncentiveItem> getItemValues() {
    ArrayList<IncentiveItem> incentiveList  = new ArrayList<IncentiveItem>();
    for (int i=0 ; i < getCount() ; i++){
        IncentiveItem incentiveItem = getItem(i);
        incentiveList.add(incentiveItem);
    }
    return incentiveList;
}