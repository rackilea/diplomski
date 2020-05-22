List<int> progressList = new ArrayList<>();
List<String> titleList = new ArrayList<>();
for (QueryDocumentSnapshot document : task.getResult()) {
    progressList.add(Integer.valueOf(document.get("progress").toString()));
    titleList.add(document.get("title").toString());
}