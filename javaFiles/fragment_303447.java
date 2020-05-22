YourActivityName.this.runOnUiThread(new Runnable() {

           @Override
           public void run() {
              camera.setImageBitmap(bitmap);
              camera.invalidate();
            }
      });