public void setValueAt(Object value, int row, int col) {
    ProduitInBonDachat tableEtry;
    try {
        tableEtry = data.get(row);

        switch (col) {
            case 0:
                tableEtry.setDesignationProduit((String) value);
                break;
            case 1:
                tableEtry.setQte((BigDecimal) value);
                break;
            case 2:
                tableEtry.setPrixDeVente((BigDecimal) value);
                break;
        }
        fireTableCellUpdated(row, col);
        if (row == nextActiveRow && activeRowIsVaid()) {
            nextRowActive();
        }
    } catch (IndexOutOfBoundsException e) {
        // IMHO, this is not an appropriate action for the
        // setValueAt method, as the contract suggest that you are
        // editing an existing row, instead provide a method in your model
        // which is responsible for inserting/adding new rows
        //tableEtry = new ProduitInBonDachat();
        //data.add(row, tableEtry);
        // don't forget to fireRowInserted!
    }

}