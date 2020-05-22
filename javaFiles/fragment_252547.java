public ResponseEntity<byte[]> getDiffPdf(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
    List<LayoutEntity> getdiffPdf = layoutRepo.findViewImages(id,1);//status=1
    String diffPdf = getdiffPdf.get(0).getdLayoutPath();
    String diffPdfStr = diffPdf;
    diffPdfStr = diffPdfStr.substring(diffPdfStr.lastIndexOf("/"));
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    String filename = diffPdfStr;
    headers.add("content-disposition", "inline;filename=" + filename); 
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    Path pdfPath = Paths.get("static/layout/pdf"+diffPdfStr);            //"/path/to/file.pdf"
    byte[] pdf = Files.readAllBytes(pdfPath);
    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdf, headers, HttpStatus.OK);
    return response;
    }