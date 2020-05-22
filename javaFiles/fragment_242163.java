try {
         String search = "#q="+jTextField.getText().toString().trim();
         search = search.replaceAll(" ","+");
         String url = "http:////www.google.com//"+search;
         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
       }
       catch (java.io.IOException e) {
           System.out.println(e.getMessage());
       }