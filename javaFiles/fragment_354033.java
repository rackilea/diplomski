@PostMapping(value = "/ocrImage")
public  ResponseEntity<GenericResponse> ocrImage(@RequestParam("file") MultipartFile file) {

    // I have created a function to store file locally and return the absolute path
    String fileName = fileStorageService.storeFile(file);

    // passing the filepath to the service method
    Object ocrDataImage = ocrService.ocrImage(fileName);
    return ResponseBuilder.buildResponse(ocrDataImage , 0, "");
}