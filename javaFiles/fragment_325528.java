JSONObject json = new JSONObject(" {\n" + "         \"displayLength\": \"4\",\n"
        + "         \"iTotal\": \"20\",\n" + "         \"users\": [\n" + "         {\n"
        + "            \"id\": \"2\",\n" + "            \"userName\": \"Test1\",\n"
        + "            \"Group\": {   id:1,\n" + "                         name:\"Test-Admin\"\n"
        + "                         }\n" + "        },\n" + "        {\n" + "            \"id\": \"17\",\n"
        + "            \"userName\": \"Test2\",\n" + "            \"Group\": {   id:1,\n"
        + "                         name:\"Test-Admin\"\n" + "                         }\n" + "        },\n"
        + "        {\n" + "            \"id\": \"32\",\n" + "            \"userName\": \"Test3\",\n"
        + "            \"Group\": {   id:1,\n" + "                         name:\"Test-Admin\"\n"
        + "                         }\n" + "        },\n" + "        {\n" + "            \"id\": \"35\",\n"
        + "            \"userName\": \"Test4\",\n" + "            \"Group\": {   id:1,\n"
        + "                         name:\"Test-Admin\"\n" + "                         }\n" + "        }  \n"
        + "\n" + "    ]\n" + "   }");

JSONArray array = json.getJSONArray("users");

String userName = "Test1";
Integer userId = null;

for (int i = 0; i < array.length() && userId == null; i++) {

    JSONObject jsonIn = (JSONObject) array.get(i);

    if (jsonIn.optString("userName").equals(userName)) {
        userId = jsonIn.optInt("id");
    }
}

System.out.println("User ID for User Name '" + userName + "' is : " + userId);