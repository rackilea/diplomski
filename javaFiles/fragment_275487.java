neighbor = neighbors.next(); <- you get first
graph.visit(neighbor); <- you visit
add_queue.add(neighbor); <- you add it without any check
while(neighbors.hasNext())
{
  neighbor = neighbors.next();
  if(!graph.isVisited(neighbor)) <- you do check for the others
  {
     add_queue.add(neighbor);
     graph.visit(neighbor);
  }
}