else if(source == deleteMI) {
        int index = nameList.getSelectedIndex();
        if(index >= 0){
            nameList.remove(index);
            numberList.remove(index);
        }
    }