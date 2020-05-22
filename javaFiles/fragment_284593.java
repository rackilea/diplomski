new Thread(new Runnable() {
public void run() {
  try {
        Socket client = server.accept();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}).start();