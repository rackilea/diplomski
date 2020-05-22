ServerSocket listener = new ServerSocket(9898);
try {
    while (true) {
        new Handler(listener.accept(), clientNumber++).start();
    }
 } finally {
     listener.close();
 }