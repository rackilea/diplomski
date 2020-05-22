Add @MultipartConfig annotation.
Always parse your request body only once and store it in a list.    
so that one part cannot consume it.

 List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());

    for (Part part : fileParts) { 

    }

File uploads = new File("/path/to/uploads");
File file = File.createTempFile("somefilename-", ".ext", uploads);

try (InputStream input = part.getInputStream()) {
    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
}