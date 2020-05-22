Timer timer = new Timer(5000, new ActionListener() {
      private int i = 0;
      public void actionPerformed(ActionEvent e) {
        if (i > 10) {
          timer.stop();
        } else {
          textArea1.append("   "+i + "\n" + newline);
          textArea1.setCaretPosition(textArea1.getDocument().getLength());
          i++;
         }
      }
   });
...
...
timer.start();