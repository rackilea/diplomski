List<List<String>> subLists = new ArrayList<>();  

for (List<String> accList : subLists) {
    service.submit(() -> {
        for (String account : accList) {
// ...