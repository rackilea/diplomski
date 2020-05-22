Runtime.getRuntime().addShutdownHook(new Thread(() -> { 
  try {
    socket.close(); 
  } catch (IOException e) {
    throw new RuntimeException(e);
  }
}));