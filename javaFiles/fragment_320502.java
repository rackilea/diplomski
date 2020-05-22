JSONArray data = jsonObj.getJSONArray("data");
for (int i = 0; i < data.length(); i++) {
    Integer prod = (Integer) data.get(i);
    System.out.println("Prod " + prod);
    // loop and add it to array or arraylist
}