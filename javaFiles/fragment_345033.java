File myFile = new File(file);
    RequestParams params = new RequestParams();
    params.put("", myFile);
    StringEntity stringEntity = new StringEntity("Content-Length" + String.valueOf(file.length()));
    FileEntity fileEntity = new FileEntity(myFile,"");
    client.put(MyApplication.getAppContext(), user.avatarUploadUrl, fileEntity, null, responseHandler);