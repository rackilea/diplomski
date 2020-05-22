mntmToggleGrid.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        if(toggleGrid) toggleGrid = false;
        else {
            toggleGrid = true;
            repaint();
        }
    }
});