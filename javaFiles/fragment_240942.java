try {
    while(true) {
      // client code here
    }
} catch (Exception e) {
     e.printStackTrace(); //  notice this line. Will save you a lot of time!
} finally {
    output.close(); //close resources here!
    input.close();
    clientsocket.close();
}