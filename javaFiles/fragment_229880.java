Adding:
synchronized(myPointArray)
{
  myPointArray.add(newPoint);
}


Iterating:
synchronized(myPointArray)
{
  for (PointF point : myPointArray)
  {
    // do stuff with the point
  }
}