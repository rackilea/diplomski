private void waitForDownloadFinished() throws Exception {
            try {
                String path = "/Download/path/";
                if (path != null) {
                    File folder = new File(path);
                    long size, reSize;
                    do {
                        size = FileUtils.sizeOfDirectory(folder);
                        Thread.sleep(5000);
                        reSize = FileUtils.sizeOfDirectory(folder);
                    } while (size != reSize);
                    System.out.println("Download completed");
                }           
} catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                getWebBrowser().quit();
            }
        }