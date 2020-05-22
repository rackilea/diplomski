availableRestaurantsTable.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String cellValue = (String)availableRestaurantsTable.getValueAt(availableRestaurantsTable.getSelectedRow(), availableRestaurantsTable.getSelectedColumn());

            if(cellValue.compareTo("Bar & Boeuf") == 0){
                JOptionPane.showMessageDialog(null, "Yeap! Same\n"+cellValue);
                menuTableMethod(title2, dataUpdate);
            }

        }