@Test
public void test() throws Exception {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // construct Type that tells Gson about the generic type
    Type dtoListType = new TypeToken<List<OrderIDDetailBean>>(){}.getType();
    FileReader fr = new FileReader("test.json");
    List<OrderIDDetailBean> dtos = gson.fromJson(fr, dtoListType);
    fr.close();
    // If it was an empty one create initial list
    if(null==dtos) {
        dtos = new ArrayList<>();
    }
    // Add new item to the list
    dtos.add(new OrderIDDetailBean("23", 34234, new Date(), 544.677));
    // No append replace the whole file
    FileWriter fw  = new FileWriter("test.json");
    gson.toJson(dtos, fw);
    fw.close();        
}