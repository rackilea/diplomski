public static class MyJsonAdapter implements JsonDeserializer<List<Person>>
  {
    List<Person> people = new ArrayList<>();
    public List<Person> deserialize( JsonElement jsonElement, Type type, JsonDeserializationContext context )
      throws JsonParseException
    {
      for (each element in the json data array) 
      {
        Person p = context.deserialize(jsonElementFromArray,Person.class );
        people.add(p);
      }
    }
    return people;
  }