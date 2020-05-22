... public class MyTableCellRenderer extends DefaultTableCellRenderer
...

        //Defined in your class somewhere
        //Add column values to it when clicked on or selected   

        private final Color selectedColumn = Color.YELLOW;
        List<String> selectedCols = new ArrayList<String>(); 

        if (selectedCols.contains(cellValue)) {
            tableCell.setBackground(selectedColumn);
        } else {
            tableCell.setBackground(UIManager.getColor("Table.background"));
        }