import com.google.gson.Gson;

class Person {
  private int age;
  private String name;
}

String json = "{'age':22,'name':'Jigar'}";
Gson gson = new Gson();
TestJsonFromObject obj = gson.fromJson(json, Person.class);