public void actionPerformed(ActionEvent e) {
   JButton source = (JButton)e.getSource();
   Set<String> keys = nahledy.keySet();

   for(String key : keys) {
      if(nahledy.get(key).equals(source)) {
         // do something with your button
      }
   }
}