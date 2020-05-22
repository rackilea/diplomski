List<Container> containers = new ArrayList<Container>();
for (String sogething : søgestreng) {
    String itemname = "I don't know"; // ?
    Integer imgid = 1234; // ?
    Container container = new Container(sogething, itemname, imgid);
    containers.add(container);
}
Container[] array = containers.toArray(new Container[containers.size()]);
listAdapter = new CustomListAdapter(this, array);