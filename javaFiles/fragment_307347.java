public static void main(String[] args) throws IOException {
    String singleStudentXmlData = "<StudentsTable>\n" +
            "  <Student name = \"a\" surname = \"b\" age = \"15\" />\n" +
            "</StudentsTable>";

    JSONObject jsonObject = XML.toJSONObject(singleStudentXmlData);
    try {
        JSONObject students = new JSONObject().put("Students", new JSONArray().put(jsonObject.getJSONObject("StudentsTable").getJSONObject("Student")));
        jsonObject.put("StudentsTable", students);
    } catch (JSONException e){
        // You can continue with your program, this is multi student case (works for your by default library behavior)
    }

    simpleTest(jsonObject);
}

private static void simpleTest(JSONObject modifiedJSONObject){

    String multiStudentXmlData = "<StudentsTable>\n" +
            "  <Student name = \"a\" surname = \"b\" age = \"15\" />\n" +
            "  <Student name = \"a\" surname = \"b\" age = \"15\" />\n" +
            "</StudentsTable>";

    JSONObject multiStudentJSONObject = XML.toJSONObject(multiStudentXmlData);

    assert(modifiedJSONObject == multiStudentJSONObject);
}