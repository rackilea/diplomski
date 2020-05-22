//...

      // show result
      final String myResult=result;
      SwingUtilities.invokeLater(new Runnable(){
         public void run(){
            JTF_address.setText(myResult);
         }
      });