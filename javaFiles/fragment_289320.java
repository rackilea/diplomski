@RequestMapping("/catalogue/displayCatalogueImage.action")
public ResponseEntity getDisplayImage(String catalogueTitleNumber,  HttpServletResponse response) throws Exception {

    System.out.println("Image Display Title number = > "+catalogueTitleNumber);

    if (StringUtils.isNotEmpty(catalogueTitleNumber)) {

        response.setHeader("Content-Type", "image/png");
        FileInputStream fin = new FileInputStream("images/"+catalogueTitleNumber);
        ServletOutputStream out = response.getOutputStream();

        IOUtils.copy(fin, out);
        IOUtils.closeQuietly(fin);

        response.flushBuffer();

        return new ResponseEntity(HttpStatus.OK);
    }

    return new ResponseEntity(HttpStatus.NOT_FOUND);
}