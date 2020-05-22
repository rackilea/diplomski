public void viewAll() {
    String addText = "  NAME\tADDRESS\tPHONE NO.\tE-MAIL ADD\n\n";
    int nonNull = 0;
    for (int i = 0; i < entry.length; i++) {
       if (entry[i] != null) {
         addText = addText + entry[i].getInfo() + "\n";
         nonNull++;
       } 

 if (nonNull == counter) break; } JOptionPane.showMessageDialog(null, new JTextArea(addText));