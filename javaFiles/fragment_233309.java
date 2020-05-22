JPanel createButtonspane(){
   bpanel = new JPanel();
   for(int i=0; i<10; i++){
      bpanel.add(new JButton(""+i));
   }
   return bpanel;
}