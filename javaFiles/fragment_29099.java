Gson gson = new Gson();
Type listType = new TypeToken<List<ItemDTO>>() {}.getType();
List<ItemDTO> data = gson.fromJson(json, listType);

for (ItemDTO itemDTO : data) {
    System.out.print(itemDTO.getLatitude());
}