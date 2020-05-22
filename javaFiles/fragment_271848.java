public static void main(String[] args) {
String input = "{\"title\": \"Idle\", \"duration\": 120, \"holdLastKeyframe\": false, \"nodeAnimations\": {"
    + "\"Upper Arm Right\": { \"position\": { },\"offsetFromPivot\": {},\"size\": {},\"rotation\": {\"0\": [ 0, 0, -4.171811 ],\"30\": [ 0, 0, -1.254342 ],\"60\": [ 0, 0, -6.620682 ],\"90\": [ 0, 0, -2.199501 ]},\"stretch\": {}},\"Upper Arm Left\": {\"position\": {},\"offsetFromPivot\": {},\"size\": {},\"rotation\": {\"0\": [ 0, 0, 7.722006 ],\"30\": [ 0, 0, 0.891409 ],\"60\": [ 0, 0, 7.101573 ],\"90\": [ 0, 0, 3.180463 ]},\"stretch\": {}},\"Spine\": {\"position\": {},\"offsetFromPivot\": {},\"size\": {},\"rotation\": {\"0\": [ 0, 0, 0 ],\"60\": [ 4.786639, 0, 0 ]},\"stretch\": {}}}}";
JsonObject jsonObject = new Gson().fromJson(input, JsonObject.class);
for (Entry<String, JsonElement> entrySet : jsonObject.get("nodeAnimations").getAsJsonObject().entrySet()) {
    System.out.println(entrySet.getKey());
    System.out.println(entrySet.getValue().getAsJsonObject().get("rotation"));
}
}