@RequestMapping(value = "/show/",produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[]  showImage(@RequestParam("image") String image) throws IOException{
        final String imagePath = "src/web/images/";

        FileInputStream input = new FileInputStream(imagePath+image);
        return IOUtils.toByteArray(input);
    }