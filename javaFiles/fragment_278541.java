@GetMapping(value = "/getVideo", produces = "video/mp4")
public StreamingResponseBody getVideo(@RequestParam(value = "library") String libraryName,
        @RequestParam(value = "fileName") String fileName) {
    Library lib = librariesConf.getConfig().getLibraries().get(libraryName.toLowerCase());
    Video video = lib.getVideoFiles().get(fileName);
    lib.getRecentlyViewed().add(video);
    librariesConf.getConfig().getLibraries().keySet().forEach((libr) -> System.out.println("LIBR: :" + libr));
    return new StreamingResponseBody() {
        public void write(OutputStream out2) throws IOException {
            try (FileInputStream out = new FileInputStream(lib.getFileDirectory(fileName))) {
                StreamUtils.copy(out, out2);       
            }
        }
    };
}