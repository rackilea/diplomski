String stringResponse = "";
   try {
      // execute GET to graph service
      WS.WSRequest wsRequest = WS.url( serviceURL ).authenticate( USERNAME, PASSWORD );
      WS.HttpResponse response = wsRequest.get();
      stringResponse = response.getString();

      ... more cool stuff ...