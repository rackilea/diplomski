Object source = new Object();
source=ev.getSource();
if(source==open){
    openFile();
}
else if(source==exitButton){
    System.exit(0);
}
throw new UnsupportedOperationException("Not supported yet.");