public class FileProcessThreads {

        private static Logger _logger = Logger.getLogger(FileProcessThreads.class);

        public  File[] getFiles(String fileLocation)  {

            _logger.info("Calling process method of FileProcessThreads class");
            File dir = new File(fileLocation);
            File[] directoryListing = dir.listFiles();
            ArrayList<File> files = new ArrayList<File>();
            if (directoryListing.length > 0)
                return directoryListing;
            _logger.info("Exiting  process method of FileProcessThreads class");
           return null;

        }
    }   

public class UploadExecutor {
    private static Logger _logger = Logger.getLogger(UploadExecutor.class);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        _logger.info("----------STARTING JAVA MAIN METHOD----------------- ");

        /*
         * 3 C:\\Users\\u6034690\\Desktop\\TWOFILE\\xml
         * a205381-tr-fr-production-us-east-1-trf-auditabilty
         */
        while (true) {

            String strNoOfThreads = args[0];
            String strFileLocation = args[1];
            String strBucketName = args[2];

            int iNoOfThreads = Integer.parseInt(strNoOfThreads);
            S3ClientManager s3ClientObj = new S3ClientManager();
            AmazonS3Client s3Client = s3ClientObj.buildS3Client();


            try {

                FileProcessThreads fp = new FileProcessThreads();
                File[] files = fp.getFiles(strFileLocation);
                try {

                    _logger.info("No records found will wait for 10 Seconds");
                    TimeUnit.SECONDS.sleep(10);
                    files = fp.getFiles(strFileLocation);
                    ArrayList<File> batchFiles = new ArrayList<File>(batchSize);
                    if(null!=files){
                        for (File path : files) {
                            String fileType =  FilenameUtils.getExtension (path.getName());
                            long fileSize = path.length();
                            if (fileType.equals("gz") && fileSize>0){
                                batchFiles.add(path);
                            }
                            //wait till list size equals to batchSize
                            if (batchFiles.size() == batchSize) {
                                //upload batch to S3
                                BuildThread BuildThreadObj = new BuildThread();
                                BuildThreadObj.buildThreadLogic(iNoOfThreads, s3Client, batchFiles, strFileLocation, strBucketName);
                                batchFiles.clear();
                            }
                        }
                    }
                    //to consider remaining or files with count<batch size
                    if (! batch.isEmpty()) {
                        BuildThread BuildThreadObj = new BuildThread();
                        BuildThreadObj.buildThreadLogic(iNoOfThreads, s3Client, batchFiles, strFileLocation, strBucketName);
                        batchFiles.clear();
                    }

                } catch (InterruptedException e) {
                    _logger.error("InterruptedException: " + e.toString());
                }
                _logger.info("Total no of Audit files = " + records.size());

            } catch (Throwable t) {
                _logger.error("InterruptedException: " + t.toString());
            }
        }
    }
}