new Thread(new Runnable(){
    @Override
    public void run() {
          runOnUiThread(new Runnable() {
              @Override
              public void run() {
                  a.startAnimation(pengesat);
              }
          });
    }
}).start();