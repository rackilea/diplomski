UpdateManager updateManager = canvas.getUpdateManager();

                    updateManager.getUpdateRunnableQueue().invokeLater(
                            new Runnable() {
                                @Override
                                public void run() {
      // my update code here
}