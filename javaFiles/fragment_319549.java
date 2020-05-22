public void actionPerformed(ActionEvent e){
    if(e.getSource() instanceof MySuperButton){

        MySuperButton btn = (MySuperButton)e.getSource();
        int[] index = btn.getIndex();
        // or
        int row = btn.getRow();
        int col = btn.getColumn();

    }
}