while (i.hasNext()) {
    Map.Entry<Integer, Integer> entry = i.next();
    if (entry.getValue() == 1) {
        System.out.println(entry.getKey());
    }
}