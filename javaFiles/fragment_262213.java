for (Map.Entry<Alpha, List<Alpha>> entry : hashmap.keySet()) {
    List<Alpha> list = entry.getValuee();
    System.out.println(entry.getKey() + "<---->");
    for(Alpha y : list) {
        System.out.print(y);
    }
    System.out.println();
}