public String buildURL(String origin, String destination)
{
StringBuilder urlBuilder = new StringBuilder();
urlBuilder("https://maps.googleapis.com/maps/api/directions/json?");
urlBuilder("origin=");
urlBuilder(origin);

urlBuilder("&destination=");
urlBuilder(destination);

urlBuilder("&key=");
urlBuilder(MY_KEY);

return urlBuilder.toString();
}