public void onShareButton() {
        dashboardController.setupViewBeforeSharing();

        new Timer().schedule(new TimerTask() {          
            @Override
            public void run() {
                Bitmap bitmap = null;   
                try {
                    bitmap = Bitmap.createBitmap(dashboardView.getWidth(),
                            dashboardView.getHeight(), Bitmap.Config.ARGB_4444);
                    dashboardView.draw(new Canvas(bitmap));
                } catch (Exception e) {
                    // Logger.e(e.toString());
                }

                FileOutputStream fileOutputStream = null;
                File path = Environment
                        .getExternalStorageDirectory();
                File file = new File(path, "wayzupDashboard" + ".png");
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
                bitmap.compress(CompressFormat.PNG, 100, bos);
                try {
                    bos.flush();
                    bos.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/png");
                share.putExtra(Intent.EXTRA_TEXT, R.string.addPassengerButton);
                share.putExtra(Intent.EXTRA_STREAM,
                        Uri.parse("file://" + file.getAbsolutePath()));
                startActivity(Intent.createChooser(share, "Share image"));

                MainActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        dashboardController.setupViewAfterSharing();   
                    }
                });

            }
        }, 300);
    }