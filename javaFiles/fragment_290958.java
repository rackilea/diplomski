// output: 
// Validating jsonInput1...
// Validating jsonInput2...
// Validating jsonInput3...
// $.element2: is missing and it is not optional
// [MyObject: element1=value1, element2=value2, element3=value3]
// [MyObject: element1=value1, element2=value2, element3=null]
// [MyObject: element1=value1, element2=null, element3=value3]

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import eu.vahlas.json.schema.JSONSchema;
import eu.vahlas.json.schema.JSONSchemaProvider;
import eu.vahlas.json.schema.impl.JacksonSchemaProvider;

public class Foo
{
  static String jsonSchema = 
    "{" + 
        "\"description\":\"Serialized MyObject Specification\"," + 
        "\"type\":[\"object\"]," + 
        "\"properties\":" + 
        "{" + 
            "\"element1\":{\"type\":\"string\"}," + 
            "\"element2\":{\"type\":\"string\",\"optional\":false}," + 
            "\"element3\":{\"type\":\"string\",\"optional\":true}" + 
        "}" + 
    "}";;

  static String jsonInput1 = "{\"element1\":\"value1\",\"element2\":\"value2\",\"element3\":\"value3\"}";
  static String jsonInput2 = "{\"element1\":\"value1\",\"element2\":\"value2\"}";
  static String jsonInput3 = "{\"element1\":\"value1\",\"element3\":\"value3\"}";

  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    JSONSchemaProvider schemaProvider = new JacksonSchemaProvider(mapper);
    JSONSchema schema = schemaProvider.getSchema(jsonSchema);

    System.out.println("Validating jsonInput1...");
    validateAndLogErrors(jsonInput1, schema);
    System.out.println("Validating jsonInput2...");
    validateAndLogErrors(jsonInput2, schema);
    System.out.println("Validating jsonInput3...");
    validateAndLogErrors(jsonInput3, schema);

    MyObject object1 = mapper.readValue(jsonInput1, MyObject.class);
    System.out.println(object1);
    MyObject object2 = mapper.readValue(jsonInput2, MyObject.class);
    System.out.println(object2);
    MyObject object3 = mapper.readValue(jsonInput3, MyObject.class);
    System.out.println(object3);
  }

  static void validateAndLogErrors(String jsonInput, JSONSchema schema)
  {
    List<String> errors = schema.validate(jsonInput);
    for (String error : errors)
    {
      System.out.println(error);
    }
  }
}

class MyObject
{
  String element1;
  String element2;
  String element3;

  void setElement1(String element1)
  {
    this.element1 = element1;
  }

  void setElement2(String element2)
  {
    this.element2 = element2;
  }

  void setElement3(String element3)
  {
    this.element3 = element3;
  }

  @Override
  public String toString()
  {
    return String.format(
        "[MyObject: element1=%s, element2=%s, element3=%s]",
        element1, element2, element3);
  }
}