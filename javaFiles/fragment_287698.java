public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\Sample.json"))); //Java 7 to read JSON into String from file

        Pattern pattern = Pattern.compile("\"children\":\\s*\\[\\s*[\"a-zA-Z\",\\s*]*]",Pattern.MULTILINE); //Pattren to find list of file i.e. content
        Matcher matcher = pattern.matcher(contents);
        while(matcher.find()) {
            String group = matcher.group();
            String newGroup = matcher.group().replaceAll("\"children\"", "\"file\"");
            contents = contents.replace(group, newGroup);
        }
        Folder folder = objectMapper.readValue(contents, Folder.class);
        System.out.println(folder);

    }