URL url = new URL("http://services.odata.org/V4/TripPinServiceRW/People?$top=2&$filter=Trips/any(d:d/Budget gt 3000)");
URL urlToEncode = new URL(url);
URI uri = new URI(urlToEncode.getProtocol(), urlToEncode.getUserInfo(), urlToEncode.getHost(), urlToEncode.getPort(), urlToEncode.getPath(), urlToEncode.getQuery(), urlToEncode.getRef());

HttpURLConnection c = (HttpURLConnection) uri.toURL().openConnection();
c.setRequestProperty("accept", "application/json");
c.setRequestMethod("GET");

BufferedReader in = new BufferedReader(newInputStreamReader(c.getInputStream()));