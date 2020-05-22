ObjectMapper mapper = new ObjectMapper(); 
Map<String,Object> data = mapper.readValue(new File(FileName), Map.class);
Map<String, Double> tags = (Map) data.get("SomeInput");

double value = 0;
for (String tag : tags.keySet()) {
    value = tags.get(tag); //Here I get all the data from the tags inside the input. E.g.: 0.830168776371308
    System.out.println(value); //It will print ADP, ADV and X values.
}