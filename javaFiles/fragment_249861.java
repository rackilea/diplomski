public static MyGeoPoint rotatePoint(MyGeoPoint point, MyGeoPoint origion, double degree)
{
double x =  origion.longitude   + (Math.cos(Math.toRadians(degree)) * (point.longitude - origion.longitude) - Math.sin(Math.toRadians(degree))  * (point.latitude - origion.latitude) / Math.abs(Math.cos(Math.toRadians(origion.latitude)));
double y = origion.latitude + (Math.sin(Math.toRadians(degree)) * (point.longitude - origion.longitude) * Math.abs(Math.cos(Math.toRadians(origion.latitude))) + Math.cos(Math.toRadians(degree))   * (point.latitude - origion.latitude));
return new MyGeoPoint(x, y);
}