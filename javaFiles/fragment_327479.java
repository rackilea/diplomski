import org.springframework.http.*; //Used with 5.1.9.RELEASE

Uri uri = "http://putmyresults.com";
byte[] bytes = MyObject.getMyBytes();

MultiValueMap<String,String> fileMap = new LinkedMultiValueMap<>();
ContentDisposition cd = ContentDisposition.builder("form-data").
name("file").filename("myFile").build();
filemap.add(HttpHeaders.CONTENT_DISPOSITION,cd.toString());

HttpEntity<byte[]> fileEntity = new HttpEntity<>(bytes,fileMap);
MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();
body.add("file",fileEntity);


HttpHeaders tokenHeader = new HttpHeaders();
tokenHeader.set("Authorization","myToken");
tokenHeader.setContentType(MediaType.MULITPART_FORM_DATA);

HttpEntity<MultiValueMap<String,Object>> requestMap = new HttpEntity<>(body,securedTokenHeaders);


new RestTemplate().exchange(uri,HttpMethod.PUT,requestMap,String.class)