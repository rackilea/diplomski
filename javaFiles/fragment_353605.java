public PathPoints (Scanner s){
  int numberCoord;
  List<Coordinates> path = new ArrayList<Coordinates>();
  numberCoord = s.nextInt();
  for(int x = 0; x < numberCoord; x++){
    Coordinates points = new Coordinates(s.nextInt(), s.nextInt());
    path.add(points);
  }