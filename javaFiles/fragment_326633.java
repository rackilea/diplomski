public int hashCode(){
   return x*y;
}

public boolean equals(Object o){
  if (o instanceof AStarNode){
    return x==((AStarNode)o).x && y==((AStarNode)o).y;
  }
  return false;
}