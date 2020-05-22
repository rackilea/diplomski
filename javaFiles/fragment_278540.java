@GetMapping(value = "/getVideo", produces = "video/mp4")
public void getVideo(@RequestParam(value = "library") String libraryName,
        @RequestParam(value = "fileName") String fileName, HttpServletResponse response) {
    Library lib = librariesConf.getConfig().getLibraries().get(libraryName.toLowerCase());
    Video video = lib.getVideoFiles().get(fileName);
    lib.getRecentlyViewed().add(video);
    librariesConf.getConfig().getLibraries().keySet().forEach((libr) -> System.out.println("LIBR: :" + libr));

    try (FileInputStream out = new FileInputStream(lib.getFileDirectory(fileName))) {
        return StreamUtils.copy(out, response.getOutputStream());
    } catch (IOException e) {
        e.printStackTrace();
    }
}