@RequestMapping(value = "/upload", method = RequestMethod.POST)
public String fileUpload(@RequestParam("file") MultipartFile file) {
    try {
        // Get the file and save it somewhere
        byte[] bytes = file.getBytes();

        //save file in server - you may need an another scenario
        Path path = Paths.get("/" + file.getOriginalFilename());
        Files.write(path, bytes);

    } catch (IOException e) {
        e.printStackTrace();
    }

    //redirect to an another url end point 
    return "redirect:/upload-status";
}