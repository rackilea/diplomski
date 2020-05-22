public void saveListToJSON(String fileName) throws
            MyCustomException {

        DateTimeFormatter dtf
        = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ObjectNode newStud;
        int id;
        String name;
        String email;
        String birthDate;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        ArrayNode root = objectMapper.createArrayNode();

        for (Person person : this.persons) {
            newStud = objectMapper.createObjectNode();
            id = person.getId();
            name = person.getName();
            email = person.getEmail();
            birthDate = person.getBirthDate().format(dtf);
            newStud.put("id", id);
            newStud.put("name", name);
            newStud.put("email", email);
            newStud.put("birthDate", birthDate);
            root.add(newStud);
        }

        try {
            objectMapper.writeValue(new File(fileName), root);
        } catch (IOException ex) {
            throw new MyCustomException("The given output file "
                    + fileName + " cannot be opened for writing.");
        }