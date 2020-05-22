FormDataMultiPart form = new FormDataMultiPart();
URI uri = new File("filepath").toURI();
InputStream data =  this.getClass().getResourceAsStream("filePath");    
FormDataBodyPart fdp1 = new FormDataBodyPart("key1", uri.toString());
FormDataBodyPart fdp2 = new FormDataBodyPart("key2",data, MediaType.APPLICATION_OCTET_STREAM_TYPE);

form.bodyPart(fdp1).bodyPart(fdp2); 
response = builder.post(ClientResponse.class, form);

Assert.assertEquals(response.getStatus(), Status.OK.getStatusCode());