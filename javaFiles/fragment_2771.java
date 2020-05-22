Iterator<JCheckBox> iterator = sbname.iterator(); 
while(iterator.hasNext()) {
   JCheckBox checkbox = iterator.next();
   if (checkbox.isSelected()) {
      iterator.remove();
      //do some more stuff
   }
}