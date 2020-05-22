final ListView listView = ((AlertDialog)dialog).getListView();
    if(indexSelected == 0){ // if "select all" is clicked - check/uncheck all items
        for(int i=0; i<itemList.length; i++){
            listView.setItemChecked(i, isChecked);
            itemBooleanList[i] = isChecked;
        }
    }else{
        itemBooleanList[indexSelected] = isChecked;
        if(!isChecked) {
            itemBooleanList[0] = false;
            listView.setItemChecked(0, false);
        }else{
            //check whether all the items are checked otherthan 'select all'
            //if true then
            //itemBooleanList[0] = true;
            //listView.setItemChecked(0, true);
        }
    }