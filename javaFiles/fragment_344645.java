Path path = Paths.get("/var/www/downloads/" + organization.id);
if (!Files.exists(path)) {    //    check if directory exists
    try {
        Files.createDirectories(path);
        System.out.println("Directory created SUCCESSFULLY.");
    } catch (IOException e) { //    failed to create
        System.out.println("Directory creation FAILED.");
        e.printStackTrace();
    }
}