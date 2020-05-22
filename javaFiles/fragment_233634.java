table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
    public void valueChanged(ListSelectionEvent event){
        int viewRow = table.getSelectedRow();
        if(viewRow < 0)
            System.out.println("LOL");
        else{
            // You add a new mouse listener...
            final int modelRow = table.convertRowIndexToModel(viewRow);
            table.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    if(e.getClickCount() == 2)
                        try {
                            new BookForm();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                }
            });
        }   

    }
});