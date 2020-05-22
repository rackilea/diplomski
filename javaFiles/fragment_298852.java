HttpClient client = HttpClientBuilder.create().build();
HttpPost post = new HttpPost(URL);
File file = new File(FOLDER_PATH + "/" + name);
FileEntity fileEntity = new FileEntity(file);
post.setEntity(fileEntity);
HttpResponse response = client.execute(post);