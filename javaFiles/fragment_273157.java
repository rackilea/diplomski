@RequestMapping(value = "/upload", method = RequestMethod.POST)
public ResponseEntity<?> uploadImages(@RequestPart("images") final MultipartFile[] files) throws IOException {
    LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
    String response;
    HttpStatus httpStatus = HttpStatus.CREATED;

    try {
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                map.add("images", new MultipartInputStreamFileResource(file.getInputStream(), file.getOriginalFilename()));
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        String url = "http://example.com/upload";

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
        response = restTemplate.postForObject(url, requestEntity, String.class);

    } catch (HttpStatusCodeException e) {
        httpStatus = HttpStatus.valueOf(e.getStatusCode().value());
        response = e.getResponseBodyAsString();
    } catch (Exception e) {
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        response = e.getMessage();
    }

    return new ResponseEntity<>(response, httpStatus);
}

class MultipartInputStreamFileResource extends InputStreamResource {

    private final String filename;

    MultipartInputStreamFileResource(InputStream inputStream, String filename) {
        super(inputStream);
        this.filename = filename;
    }

    @Override
    public String getFilename() {
        return this.filename;
    }

    @Override
    public long contentLength() throws IOException {
        return -1; // we do not want to generally read the whole stream into memory ...
    }
}