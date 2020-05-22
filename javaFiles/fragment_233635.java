table.addMouseListener(new MouseAdapter(){
    public void mouseClicked(MouseEvent e){
        if(e.getClickCount() == 2)
            int selectedRow = table.getSelectedRow();
            if (selectedRow > -1) {
                int modelRow = table.convertRowIndexToModel(selectedRow);
                try {
                    new BookForm();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
    }
});