public static List<ModelDoa> getData() {

String[] data = getResources().getStringArray(R.array.doasore);

List<ModelDoa> list = new ArrayList<>();

list.add(new ModelDoa("London", ModelDoa.DOA_PAGI));
list.add(new ModelDoa("Amsterdam", ModelDoa.DOA_PAGI));
list.add(new ModelDoa("Berlin", ModelDoa.DOA_PAGI));

// error code is here
for (int i = 0; i < data.length; i++) {
    list.add(new ModelDoa(data[i], ModelDoa.DOA_PAGI));
}

return list; }