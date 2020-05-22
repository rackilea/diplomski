@RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<String> addQuestion2(String question, @RequestPart("file") MultiPartFile file)  {
    QuestionPostDto dtoObject = new ObjectMapper().readValue(request, QuestionPostDto.class); 
    // do sth
}

Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

------WebKitFormBoundary7MA4YWxkTrZu0gW
Content-Disposition: form-data; name="file"; filename="QLbLFIR.gif"
Content-Type: image/gif


------WebKitFormBoundary7MA4YWxkTrZu0gW
Content-Disposition: form-data; name="request"

{
    "key": "value"
}
------WebKitFormBoundary7MA4YWxkTrZu0gW--