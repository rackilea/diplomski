public static Result menu() throws IOException {

    String path = Play.application().resource("/resources/menu.json").toString();

    String content = Files.toString(new File(path), Charsets.UTF_8);

    return ok(content).as("JSON");
}