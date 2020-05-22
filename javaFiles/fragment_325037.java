if (sellings.containsKey(k)) {
    sellings.get(k).add(a);
} else {
    List<Article> list = new ArrayList<>();
    list.add(a);
    sellings.put(k, list);
}