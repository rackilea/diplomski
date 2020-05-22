ObjectMapper mapper = new ObjectMapper();

//JSON from file to Object
Fonction fonction= mapper.readValue(new File("c:\\fonction.json"), Fonction.class);

//JSON from String to Object
Fonction fonction= mapper.readValue(fonctionJsonString, Fonction.class);