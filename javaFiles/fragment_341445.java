@PostMapping(value = "/api/file/upload", headers = {"content-type=multipart/*"})
public @ResponseBody String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
    Path TO = Paths.get("/Users/myusername/Desktop/newfileName");
    try {
        try {
            Files.copy(file.getInputStream(), TO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("FAIL2! -> message2 = " + e.getMessage());
        }
        return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error -> message = " + e.getMessage();
    }
}