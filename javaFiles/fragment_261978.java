StringBuilder urlString = new StringBuilder();       
urlString.append("http:/localhost:8080/search/ByLatLngRadius?lat=");

urlString.append( latitude); 
// use this if latitude is double
//   urlString.append( Double.toString(latitude));
urlString.append("&lng=");
//  Double.toString(longitude)
urlString.append( longitude);
urlString.append("&radius=");
urlString.append(radius);