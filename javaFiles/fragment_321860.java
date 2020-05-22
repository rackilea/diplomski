JButton source = (JButton) ev.getSource();
if(source == open){
    openFile();
}
else if(source == exitButton){
    System.exit(0);
}
else
    throw new UnsupportedOperationException("Not supported yet.");