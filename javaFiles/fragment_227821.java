final InputStream in = new FileInputStream("json.json");
try {
  for (Iterator it = new ObjectMapper().readValues(
      new JsonFactory().createJsonParser(in), Map.class); it.hasNext();)
    System.out.println(it.next());
}
finally { in.close();} }