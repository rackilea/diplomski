List<String> key4_object = ...;
JsonParser parser = new JsonParser();
for (String i : key4_object){
    BuildJson bj = new BuildJson(parser.parse(i));
    String new_json = bj.buildJson();
    System.out.print(gson.toJson(new_json));
}