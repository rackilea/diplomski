ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3));
JsonObject jsonObject = new JsonObject();
JsonArray jsonArray = new JsonArray();
for (Integer value : arrayList) {
    jsonArray.add(new JsonPrimitive(value));
}
jsonObject.add("selected", jsonArray);