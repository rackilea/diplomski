public List<DataRow> compare(boolean Int) {
    for(int i = 0; i<table.getRowCount(); i++){
        Comparable currentVal = (Comparable) argument.resolve(row).getValue();
        DataRow compare = table.getRow(i);
        Comparable compareVal = (Comparable) argument.resolve(compare).getValue();
        // if there's a new minimum or there's a new maximum
        int comparison = currentVal.compareTo(compareVal);
        if((comparison > 0 && minimum) || (comparison < 0 && maximum)){
            row = compare;
            rowlist.clear();
            rowlist.add(compare);
        }
        // if there's a duplicate minimum/maximum
        else if(comparison == 0)
            rowlist.add(compare);
    }
    return rowlist;
}