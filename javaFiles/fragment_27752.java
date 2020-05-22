public void moveToward(Point2D destination) 
{
  if (CanMove()) 
  { 
    var distanceToDestination = Geometry.Distance(CurrentPosition, destination);
    var distancePerTurn = Geometry.Length(Direction);
    if (distanceToDestination <= distancePerTurn)
    {
      CurrentPosition = destination;
    }
    else
    {
      CurrentPosition = Geometry.Add(CurrentPosition, Direction);
    }   
  }
}