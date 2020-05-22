Runnable uploadJob = new Runnable() { 
        public void run() {
            for(FileContainerBean fileContainer:fileContainerList){
                FileUpload fileUpload=new FileUpload(fileContainer.getFile());
                fileUpload.run();
                // continues after the file is uploaded
            }
        }
    };

    new Thread(uploadJob).start();