//read json file data to String
      byte[] jsonData = Files.readAllBytes(Paths.get("places.txt"));

      //create ObjectMapper instance
      ObjectMapper objectMapper = new ObjectMapper();

      Place place = objectMapper.readValue(jsonData, Place.class);

      System.out.println("Place Object\n"+ place);
    }
}