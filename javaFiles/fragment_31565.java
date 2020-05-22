public void run() {
    myLastModified = getLastModified(mFile.getName()); // get last stored value for this file (use file name or other key)
    int total =0;

    final URL         url;
    HttpURLConnection httpURLConnection = null;
    try {
        try {
            url = new URL(mUrl);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);

            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setRequestMethod("GET");

            //*** new way to handle download process
            total = httpURLConnection.getContentLength();
            if(mFile.exists()){
                if(mFile.length() == total){
                    //we are done, return.
                    return;
                }else{
                    //file was not completly donwloaded, now check lastModified:
                    long lastModified = httpURLConnection.getLastModified();//this gets the header "Last-Modified" and convert to long
                    if (lastModified == myLastModified) { //myLastModified should be retrived on each download and stored locally on ur system
                        downloadedLength = mFile.length();
                        Log.e("downloadedLength ", downloadedLength + "");
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setDoInput(true);

                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.setRequestMethod("GET");

                        httpURLConnection.setRequestProperty("Range", "bytes=" + downloadedLength + "-"+ total); //add + total (TO)

                        //append mode
                        fileOutputStream = new FileOutputStream(mFile, true);
                    }else{
                        //file was modified after 1st uncompleted-download:
                        storeLastModified(lastModified, mFile.getName()); // use file name as key. can store in db or file ...

                        //don't set ant Range ... we want full download, with a fresh file
                        fileOutputStream = new FileOutputStream(mFile);
                    }//last mod IF

                }//Length check
            }else{
                //file not exist at all, create new file, set no Range we want full download...
                mFile.createNewFile();
                fileOutputStream = new FileOutputStream(mFile);
            }//file exists.

        } catch (IOException e) {
            e.printStackTrace();
        }
        final int responseCode;

        try {
            responseCode = httpURLConnection.getResponseCode();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ER UPDATE ", e.getMessage());
        }

        //*****
        if (responseCode == 200 || responseCode == 206) {
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("IOException ", e.getMessage());
            }
            final byte[] buffer   = new byte[4 * 1024];
            int          length   = -1;
            int          finished = 0;
            long         start    = System.currentTimeMillis();
            try {
                while ((length = inputStream.read(buffer)) != -1) {
                    if (!isDownloading()) {
                        throw new CanceledException("canceled");
                    }
                    fileOutputStream.write(buffer, 0, length);
                    finished += length;
                    if (System.currentTimeMillis() - start > 1000) {
                        onDownloadProgressing(finished, total);
                        start = System.currentTimeMillis();
                    }
                }
                onDownloadCompleted();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("ER UPDATE ", e.getMessage());
            }
        } else {
            Log.e("responseCode ", responseCode + "");
        }
    } catch (DownloadException e) {
        e.printStackTrace();
        Log.e("ER UPDATE ", e.getMessage());
    } catch (CanceledException e) {
        e.printStackTrace();
        Log.e("ER UPDATE ", e.getMessage());
    }
}