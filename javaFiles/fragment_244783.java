JList list = new JList(someArrayofData);
 list.addListSelectionListener(new ListSelectionListener(){
      public void valueChanged(ListSelectionEvent e){
            int selectedIndex = list.getSelectedIndex();
            //refresh the content based on the index
            setContent(selectedIndex);
      }
});