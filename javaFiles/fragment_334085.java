@RequestMapping(value = "/test/", method = RequestMethod.GET)
    public Response getFileTest(@RequestParam(value="path", defaultValue="/home") String path){
        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject("http://localhost:8086/ATS/client/file/?path={path}", Response.class, path);
        if (response.isStatus() && response.isSuccess()){
            try {
                byte[] parseBase64Binary = DatatypeConverter.parseBase64Binary((String)response.getResult());
                Files.write(Paths.get("test.txt"),parseBase64Binary );
            } catch (IOException e) {
            }
        }
        return response;
    }