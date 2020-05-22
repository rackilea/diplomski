HttpGet httpGet;
            RequestConfig requestConfig;
            getProxySettings();

            //Check to see if there is a proxy availabble. 
            if (!LicensePreloader.proxyAddr.equals("")) {
                requestConfig = RequestConfig.custom()
                        .setSocketTimeout(5000)
                        .setConnectTimeout(5000)
                        .setConnectionRequestTimeout(5000)
                        .setProxy(new HttpHost(LicensePreloader.proxyAddr, LicensePreloader.proxyPort))
                        .build();

            } else {
                //No proxy was available, just use regular internet. 
                requestConfig = RequestConfig.custom()
                        .setSocketTimeout(5000)
                        .setConnectTimeout(5000)
                        .setConnectionRequestTimeout(5000)
                        .build();
            }
            httpGet = new HttpGet(this.remoteUrl);
            HttpResponse response;
            InputStream remoteContentStream = null;
            OutputStream localFileStream = null;
            try {
                httpGet.setConfig(requestConfig);
                response = httpClient.execute(httpGet);

                //This builds the content of our file we're downloading. 
                remoteContentStream = response.getEntity().getContent();
                long fileSize = response.getEntity().getContentLength();
                File dir = localFile.getParentFile();
                dir.mkdirs();

                localFileStream = new FileOutputStream(localFile);
                //Set the buffer, in our use case, it's always the deafult 8192 bytes.
                byte[] buffer = new byte[bufferSize];
                int sizeOfChunk;
                int amountComplete = 0;
                //Simply loop through and download the file in 'chunks' 
                while ((sizeOfChunk = remoteContentStream.read(buffer)) != -1) {
                    localFileStream.write(buffer, 0, sizeOfChunk);
                    amountComplete += sizeOfChunk;
                    updateProgress(amountComplete, fileSize);

                }
                return localFile;
            } finally {
                //Make sure to clean everything up. 
                try {
                    if (remoteContentStream != null) {
                        remoteContentStream.close();
                    }
                    if (localFileStream != null) {
                        localFileStream.close();
                    }
                } catch (IOException ex) {
                    //If we're here, it's likely because the internet conneciton
                    //couldn't be established, or it was cut short in the middle. 
                    ex.printStackTrace(System.out);
                    failed();
                }
            }
        }