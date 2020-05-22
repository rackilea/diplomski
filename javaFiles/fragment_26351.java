import org.bson.BsonReader;
import org.bson.Document;
import org.bson.json.JsonReader;
import org.bson.codecs.DecoderContext;

Object object = document.get("zonedDateTime");

ZonedDateTimeCodec codec = (ZonedDateTimeCodec) codecRegistry.get(ZonedDateTime.class);
BsonReader reader = new JsonReader(((Document) object).toJson());
ZonedDateTime zdt = codec.decode(reader, DecoderContext.builder().build());
System.out.println(zdt);