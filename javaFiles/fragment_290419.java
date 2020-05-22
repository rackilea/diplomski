String destPath = "filename.txt";        

if (!filesToDownload.isEmpty()) {
            for (String fileDownloadName : filesToDownload) {
                success = false;
                  sftpChannel.get(fileDownloadName , destPath);