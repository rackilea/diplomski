List<Item> myListData = ...;
for(Item item : myListData){
    if(isNextItem(Item){
        listView.smoothScrollToPosition(myListData.indexOf(item));
        break;
    }
}