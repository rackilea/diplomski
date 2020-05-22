public void actionPerformed(ActionEvent event) {    
String[] anArray=null;  
  if (event.getSource() == reading) {
        String s = txt1.getText();
        String delims = expression.getText(); 
        anArray = s.split(delims);
        result.setText("");
        print(anArray);
    } 
    LinkedList<String> mkList;
    LinkedList<String> aList = new LinkedList<String>();
    if(anArray!=null)        
     aList = mkList(anArray);

} // actionPerformed