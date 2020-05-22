public void onLocationChanged(Location location)
{
if (location != null)
{
  // Do you have to create a new Location instance?
  Location myLocation = new Location(location);
  this.updateSpeed(myLocation);
  this.speedAlert(myLocation);

  }
}