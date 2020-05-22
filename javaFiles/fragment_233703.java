int id = 123;
String questionText = "some text";
int[] nodes = new int[] { 123, 111 };

JSONObject question = new JSONObject();
question.put(":id", id);
question.put(":question text", questionText);
question.put(":nodes", nodes);
JSONObject json = new JSONObject();
json.put(":question", question);

String jsonString = json.toString();