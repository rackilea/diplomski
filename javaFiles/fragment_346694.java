ObjectMapper mapper = new ObjectMapper();


  JavaType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, ArrayList.class) ;


  List<List> results;

  try {
        results = (List<List>)mapper.readValue(jsonData, type);

        Coordinate[] coordinates = new Coordinate[results.size()];

    for (int i = 0; i < list.size(); i++) {
       coordinates[i] = new Coordinate(Double.parseDouble((String)results.get(i).get(0)),Double.parseDouble((String)results.get(i).get(1)));
     }
  } catch (JsonParseException e) {
  } catch (JsonMappingException e) {
  } catch (IOException e) {
  }