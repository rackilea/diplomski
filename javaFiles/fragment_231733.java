@RequestMapping(value = "/get-doc",method = RequestMethod.GET, produces="application/vnd.openxmlformats-officedocument.wordprocessingml.document")
public @ResponseBody byte[] getDoc() {
    File file = userService.getDocx();
    FileInputStream fis = new FileInputStream(file);
    byte[] doc = IOUtils.toByteArray(fis);
    return doc;
}