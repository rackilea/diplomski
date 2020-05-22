InputStream bis = new InputStream(connection.getInputStream());
            Log.d("TEST","Length of Input " +bis.available());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            int read = 0;
            byte[] buffer = new byte[SIZE_OF_IMAGE];
            byte[] inBuff = new byte[32678]
            while ((read = bis.read(inBuff, 0, 32768)) > 0) {
                   // copy in buffer what have been read
                   // from the input stream
            }

            // close the is
            Bitmap bmp = BitmapFactory.decodeByteArray(buffer, 0, buffer.length);