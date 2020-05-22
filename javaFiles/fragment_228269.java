try {
        while(true) {

            DataInputStream is = new                      DataInputStream(sock.getInputStream());
          System.out.println("" +is.readLine());

            line =is.readLine();

        } // end of while
    } catch(Exception ex) {}
}