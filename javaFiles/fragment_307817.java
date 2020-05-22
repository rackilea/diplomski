private void fileUploadValidation (Vector<String> fileList, String uploadedFileName){
        boolean isFileExistis = false;
        Object[] objArr = fileList.toArray();
        for (int i = 0; i < objArr.length; i++) {
            String fileName = objArr[i].toString();
            isFileExistis = fileName.contains(uploadedFileName);
            if (isFileExistis) {
                LOG.info("Uploaded file '" + uploadedFileName + "' was transferred successfull ...");
                break;
            }else if(i >= objArr.length){
                LOG.info("Uploaded file '" + uploadedFileName + "' was failed to transfer ...");
            }

        }
    }