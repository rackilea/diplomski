FileOutputStream f = null;
            try {
                f = openFileOutput(FileName, MODE_PRIVATE);
            } catch (Exception e) {
                e.printStackTrace();
            }

            InputStream in = c.getInputStream();
            byte[] buffer = new byte[1024];
            int len1 = 0;
            while ((len1 = in.read(buffer)) > 0) {
                f.write(buffer, 0, len1);
            }
            f.close();

            player = new MediaPlayer();
            FileInputStream fis = new FileInputStream("/data/data/com.comm/files/"+ FileName);
            player.reset();
            player.setDataSource(fis.getFD());
            player.prepare();
            player.start();
            fis.close();