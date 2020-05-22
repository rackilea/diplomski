new Thread(
  new Runnable() { 
    public void run() {
      new Timer().scheduleAtFixedRate(new TimerTask() {
        public void run()   {
          started = true;
          word = "";
          for (int i = 0; i < lenght+1; i++)
          {
            int j = rand.nextInt((max-min) + 1) + min;
            word += tr.Translate(j);
          }

          // This will update your txt instance without the need of a Handler
          runOnUiThread(new Runnable() {
            public void run() {
              txt.setText(word);
            }
          });
        }
      }, 0, 5000);
    }
  }).start();