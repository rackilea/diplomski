JsonParser jp = map.getFactory().createParser(new File("test.json"));
// advance stream to START_ARRAY first:
jp.nextToken();
// and then each time, advance to opening START_OBJECT
while (jp.nextToken() == JsonToken.START_OBJECT)) {
Card card = mapper.readValue(jp, Card.class);
   // process
   // after binding, stream points to closing END_OBJECT
}