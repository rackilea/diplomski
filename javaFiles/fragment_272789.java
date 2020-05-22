public static void writeUserBD(final String name, final String surname, final int age) throws IOException {
    final Path jsonFile = Paths.get("Test/TestUser.json");
    final JsonArray users = new JsonArray();

    // Read all existing users
    if (Files.isRegularFile(jsonFile)) {
        try (final JsonReader r = new JsonReader(Files.newBufferedReader(jsonFile))) {
            r.beginArray();

            while (r.hasNext()) {
                final JsonObject user = new JsonObject();

                r.beginObject();
                r.nextName();
                user.addProperty("name", r.nextString());
                r.nextName();
                user.addProperty("surname", r.nextString());
                r.nextName();
                user.addProperty("age", r.nextInt());
                r.endObject();
                users.add(user);
            }

            r.endArray();
        }
    }

    // Create the new user
    final JsonObject user = new JsonObject();

    user.addProperty("name", name);
    user.addProperty("surname", surname);
    user.addProperty("age", age);
    users.add(user);

    // Write all users
    try (final BufferedWriter w =
            Files.newBufferedWriter(jsonFile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
        w.write(users.toString());
    }
}