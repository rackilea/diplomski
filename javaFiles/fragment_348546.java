@RequestMapping("{fileName}")
    public void getCsv(HttpServletResponse response, @PathVariable String  fileName) {
    String[] parts = fileName.split(".")[0].split("_");
    String id = parts[0];
    String timestamp = parts[2];
}