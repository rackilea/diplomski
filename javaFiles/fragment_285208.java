String keyUrlString = request.getAttribute("keyUrl").toString();
URL keyURL   = new URL(keyUrlString);
BufferedReader in = new BufferedReader(
new InputStreamReader(keyURL.openStream()));

String inputLine;
  while ((inputLine = in.readLine()) != null)
     //process