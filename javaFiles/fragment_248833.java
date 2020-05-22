@RequestMapping(value = "/book/upload",
        method = RequestMethod.POST,
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public String upload(@RequestParam(value = "file") MultipartFile file) throws IOException {

    HashMap<String, List<String>> data = ReadExcelUtil.readData(file);
    StringBuilder response = new StringBuilder();
    data.forEach((String key, List<String> value) -> {
        response.append("Data for ").append(key).append(" column:\n");
        value.forEach((String val) -> response.append(val).append("\n"));
    });
    return response.toString();
}