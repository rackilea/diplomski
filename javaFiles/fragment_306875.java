@PostMapping(value = "/documents")
@Timed
public ResponseEntity<DocumentDTO> createDocument(@RequestPart String document, @RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) throws URISyntaxException {

    DocumentDTO documentDTO = convertStringToDTO(document);

    DocumentDTO result = documentService.save(documentDTO, file);
    return ResponseEntity.created(new URI("/api/documents/" + result.getId()))
        .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
        .body(result);
}

// com.fasterxml.jackson.databind.ObjectMapper;
private DocumentDTO convertStringToDTO(String document) {
    ObjectMapper objectMapper = new ObjectMapper();
    DocumentDTO documentDTO = null;
    try {
        documentDTO = objectMapper.readValue(document, DocumentDTO.class);
    } catch (IOException e) {
        log.error("DocumentString to JSON", e);
    }
    return documentDTO;
}