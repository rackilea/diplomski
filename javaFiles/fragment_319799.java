public ResponseEntity<?> getFile(@PathVariable String fileName) {
        try {

            String filePath = new ClassPathResource(fileName+".xml").getFile().getPath();
            File file = new File(filePath);
            InputStream xmlFileInputStream = new FileInputStream(file);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            /*headers.setContentType(MediaType.APPLICATION_XML);
            String filename = fileName+".xml";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");*/
            return ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(xmlFileInputStream));
        }