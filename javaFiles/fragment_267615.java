public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        MainFrame m = new MainFrame();
      }
    });