File processing = new File(processingFolderName 
                        + File.separator 
                        + finalFileToProcess.getName());
boolean fileMoveCompleted = finalFileToProcess.renameTo(processing);
File finished = new File(successFolderName 
                        + File.separator 
                        + finalFileToProcess.getName());
fileMoveCompleted = processing.renameTo(finished);