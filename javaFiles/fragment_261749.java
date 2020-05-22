public List<XWPFTableCell> getTableCells(){
    if(tableCells == null){
        //Here it is created
        List<XWPFTableCell> cells = new ArrayList<XWPFTableCell>();
        for (CTTc tableCell : ctRow.getTcList()) {
            cells.add(new XWPFTableCell(tableCell, this, table.getPart()));
        }
        this.tableCells = cells;
    }
    return tableCells;
}