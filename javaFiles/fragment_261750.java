public XWPFTableCell getTableCell(CTTc cell) {
    for(int i=0; i<tableCells.size(); i++){
        if(tableCells.get(i).getCTTc() == cell) return tableCells.get(i); 
    }
    return null;
}