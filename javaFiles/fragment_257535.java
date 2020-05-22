public void actionPerformed(ActionEvent e) {
     if(jso != null )
         try {
                jso.call("updateWebPage", new String[] {txt.getText()});
             }
             catch (Exception ex) {
                 ex.printStackTrace();
             }
 }