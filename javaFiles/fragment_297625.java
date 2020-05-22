Row newRow = getNextRow();
if(!previousRows.contains(newRow)){
    previousRows.put(newRow);
    rowsInOrder.add(newRow);
} 
previousRows.get(newRow).incrementCount();