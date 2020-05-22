String fileName = "D:\\file.json";
Gson gson = new Gson();
Test test = null;
try (Reader reader = new FileReader(fileName)) {
    test = gson.fromJson(reader, Test.class);
} catch (IOException e) {
    e.printStackTrace();
}

test.getTests().add("pineapple");
String newJson = gson.toJson(test);
System.out.println(newJson);

try (Writer writer = new FileWriter(fileName)) {
    gson.toJson(test, writer);
}