@Secured( "ROLE_ADMIN")
@RequestMapping(value = "/getImage/{img_name:.+}")
public  ResponseEntity<byte[]> getImage(@PathVariable String img_name)
        throws InternalServerError {

    byte[] data;
    try {
        String realpath = "D:\\Project\\images\\" + img_name;
        Path path = Paths.get(realpath);
        data = Files.readAllBytes(path)


    }catch (IOException e){
        data = null;
    }

    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.IMAGE_JPEG);
    return new ResponseEntity<byte[]>(data , headers, HttpStatus.OK);
}