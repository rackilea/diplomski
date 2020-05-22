String json = "[{\"foo\": \"bar\"},{\"foo\": \"biz\"}]";
JsonFactory f = new JsonFactory();
JsonParser jp = f.createJsonParser(json);
// advance stream to START_ARRAY first:
jp.nextToken();
// and then each time, advance to opening START_OBJECT
while (jp.nextToken() == JsonToken.START_OBJECT)) {
    Foo foobar = mapper.readValue(jp, Foo.class);
    // process
    // after binding, stream points to closing END_OBJECT
}

public class Foo {
    public String foo;
}