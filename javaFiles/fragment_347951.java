LinkedList<Node> links = new LinkedList<Node>();
links.add(firstNode);
links.add(secondNode);
links.add(thirdNode);

/* For loop */
for(int i = 0; i < links.size(); i++) {
    System.out.println(links.get(i).getLink());
}

/* For-each loop */
for(Node node: links) {
    System.out.println(node.getLink());
}

/* While Loop*/
int i = 0;
while (links.size() > i) {
    System.out.println(links.get(i++).getLink());
}

/* Iterator */
Iterator<Node> it = links.iterator();
while (it.hasNext()) {
    System.out.println(it.next().getLink());
}