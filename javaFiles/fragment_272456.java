for (int j = 0;  j < itemList.size(); j++){
    String tempString = itemList.get(j);
    if(tempString.equals(selectedItem)) {
        itemList.remove(j--);
        //               ^
        // you should minus the current j, if don't the next is skipped
    }
}