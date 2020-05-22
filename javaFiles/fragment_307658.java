public ArrayList<Integer> getRandomObject(JSONArray jsonArray, int indexesWeeNeed){
    Random rn = new Random();
    Set<Integer> generated = new LinkedHashSet<>();
    while(generated.size() < indexesWeeNeed){
        int index = rn.nextInt(10);
        JSONObject jsonObject = (JSONObject) jsonArray.get(index);
        int age = jsonObject.getInt("age");
        if(age<961) {
            generated.add(index);
        }
    }
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.addAll(generated);
    return arrayList;
}