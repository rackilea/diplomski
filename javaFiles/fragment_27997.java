Files.write(
    Paths.get("/path/to/outfile.txt"), 
    toWrite, 
    StandardCharsets.UTF_8, 
    StandardOpenOptions.CREATE, 
    StandardOpenOptions.TRUNCATE_EXISTING );