for (HashMap<String, String> map : mylist) {
    String name = map.get("name");
    if (name.contains(typedText)) {
       // Create a copy of the whole map
       mylist1.add(new HashMap<String, String>(map));
    }
}