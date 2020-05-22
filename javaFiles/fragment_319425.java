//calculate the paths
for ( Iterator d = destinations.iterator(); d.hasNext(); ) {
  Node destination = (Node) d.next();
  Path path = pf.getPath( destination );

  //do something with the path
}