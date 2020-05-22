WebConversation conversation = new WebConversation();
WebRequest  request = new GetMethodWebRequest("http://your-site-to-test.com/path-to-your-upload-form");
WebResponse response = conversation.getResponse(request);
WebForm form = response.getFormWithName("stockImageUpload");   
UploadFileSpec uploadFileSpec = new UploadFileSpec("test.jpg",new File("C:/test.jpg"), "image/jpeg"); 
form.setParameter("propertyImage", new UploadFileSpec[] {uploadFileSpec});