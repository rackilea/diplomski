MultipartEntity entity = new MultipartEntity();
entity.addPart("optionName", "cool");
entity.addPart("file", new FileBody("/path/to/your/file"));
....

post.setEntity(entity);