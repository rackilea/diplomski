private class ButtonHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        for(int i = 0;i< grid.length; i++){
            for(int j = 0;j < grid.length;j++){
                if(source == grid[i][j]){
                    JButton clicked == grid[i][j];
                    // do something with this 
                }
            }
        }
    }
}