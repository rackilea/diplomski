Map<Integer, List<Double>> fuelSavings = null;
JsonElement jElement = new JsonParser().parse("[[12], [13]]");
JsonObject jObject = jelement.getAsJsonObject();
if (jObject.isJsonArray()) {
    fuelSavings = new HashMap<Integer, List<Double>>();
    List<List<Double>> temporaryList = new Gson().fromJson(jElement, new TypeToken<List<List<Double>>>(){}.getType());
    int index = 0;
    for(List<Double> temporaryListMember: temporaryList) {
        fuelSavings.put(index++, temporaryListMember);
    }
} else /* this is a map */ {
    fuelSavings = new Gson().fromJson(jElement, new TypeToken<Map<Integer, List<Double>>>(){}.getType());
}