@GetMapping(path = "/download")
public ResponseEntity<String> download(@RequestParam(name = "ids") long[] ids) {
    // ... other code ...
    XSSFWorkbook workbook = createWorkbook(reports);

    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType("text", "plain");
        workbook.write(outputStream);
        workbook.close();
        return new ResponseEntity<>(Base64.getEncoder().encodeToString(outputStream.toByteArray(), headers, HttpStatus.OK);
    } catch (IOException e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}