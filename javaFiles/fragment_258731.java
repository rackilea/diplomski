Runnable worker = new Runnable() {  
  public void run() {
     jList.setListData(textLines.toArray());
  } 
};
SwingUtilities.invokeLater(worker);