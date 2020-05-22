Iterator<Map.Entry<String, HashSet<String>>> itr1 = remarksMap.entrySet().iterator();

while (itr1.hasNext()) {
    Map.Entry<String, HashSet<String>> entry = itr1.next();
    System.out.println(entry.getKey());
    Iterator<String> itr2 = entry.getValue().iterator();

    while (itr2.hasNext()) {
        System.out.println(itr2.next());
    }
}