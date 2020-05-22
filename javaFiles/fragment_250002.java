if (source == mybutton)
       {
        StringBuilder usual = new StringBuilder();
        while(i < 11) {
        usual.append(" ").append(i);
            i++;
                     }
        JOptionPane.showMessageDialog(null, usual, "1-10",
             JOptionPane.PLAIN_MESSAGE);
                 setVisible(true);
        i=1;//////////////////MAKE i=1 EVERYTIME////////////////
        }
     {
     if (source == mybutton2)
        {
    StringBuilder reverse = new StringBuilder();
        while (two > 0) {
        reverse.append(" ").append(two);
        two--;
   }
        JOptionPane.showMessageDialog(null,reverse,"10-1",
                JOptionPane.PLAIN_MESSAGE);
                setVisible(true);two=11;/////////////////MAKE two=11 EVERYTIME////
   }

     }