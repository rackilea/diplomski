for (String[] line : data) {
    List<String> info = new ArrayList<String>();
    info.add(line[1]);
    info.add(line[2]);
    listDataChild.put(line[0], info);
}