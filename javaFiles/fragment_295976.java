try {
     Socket socket = new Socket("localhost", 5000);
     in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

     // !!
     new Thread(new Runnable() {

        @Override
        public void run() {
           try {
              while (true) {
                 final String str = in.readLine();
                 if (str == null) {
                    break;
                 } else {

                    // ***** call Swing code on the Swing event thread:
                    SwingUtilities.invokeLater(new Runnable() {
                       public void run() {
                          jta.append(str + "\n");
                       }
                    });

                    // String sms = jtf.getText().trim();
                    // if ("BYE".equals(sms)) {
                    //    out.println("BYE");
                    //    break;
                    // }
                    // ***** don't call this here!!! *****
                    // out.println("line " + sms);
                 }
              }
           } catch (IOException ex) {
              System.err.println(ex);
           }
        }
     }).start();

     out = new PrintWriter(socket.getOutputStream(), true);
  } catch (IOException ex) {
     jta.append(ex.toString() + '\n');
  }