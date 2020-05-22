@RequestMapping("/picture/{id}")
@ResponseBody
public HttpEntity<byte[]> getArticleImage(@PathVariable String id) {

    logger.info("Requested picture >> " + id + " <<");

    // 1. download img from http://internal-picture-db/id.jpg ... 
    byte[] image = ...

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_JPEG);
    headers.setContentLength(image.length);

    return new HttpEntity<byte[]>(image, headers);
}