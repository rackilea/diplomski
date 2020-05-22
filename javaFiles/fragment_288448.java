for (int i = 0; i <= model.getRowCount(); i++) {
    try{
        Double d = Double.parseDouble((String) model.getValueAt(i, 4));
        Double d2 = Double.parseDouble((String) model.getValueAt(i, 5));
        Double d3 = d * d2;
        model.setValueAt(d3, i, 6);
    } catch (NullPointerException | NumberFormatException e){
        model.setValueAt("N/A", i, 6);
    }
}