JPanel createButtonspane(){
   bpanel = new JPanel();
   for(int i=0; i<10; i++){
      JButton button = new JButton(""+i);
      buttons.add(button);
      bpanel.add(button);
   }
   return bpanel;
}