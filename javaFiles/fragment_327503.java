try {
    String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36";
    String url = "https://www.maltairport.com/wp-content/themes/mia/flightsinfo.php?arrivalsDepartures_action=getArrivalsDepartures";
    String referer = "https://www.maltairport.com/passenger/flights-landing/arrivals-departures/";
    String host = "www.maltairport.com";

    Document doc = Jsoup.connect(url).userAgent(userAgent).header("Host", host).header("Referer", referer).ignoreContentType(true).get();

    JSONObject jsonObject = (JSONObject) new JSONParser().parse(doc.body().text());

    JSONArray arrivals = (JSONArray) jsonObject.get("arrivals");
    JSONArray departures = (JSONArray) jsonObject.get("departures");

    System.out.println("departures");

    for (Object object : departures) {
        jsonObject = (JSONObject) object;
        System.out.println("Flight: " + jsonObject.get("flightNumber") + "\n\t" + "To: " + jsonObject.get("airportName")
                + " SCH: " + jsonObject.get("scheduledTime") + " EST: " + jsonObject.get("estimatedTime") + " Status: " + jsonObject.get("remarks"));
    }

    System.out.println("\narrivals");

    for (Object object : arrivals) {
        jsonObject = (JSONObject) object;
        System.out.println("Flight: " + jsonObject.get("flightNumber") + "\n\t" + "To: " + jsonObject.get("airportName")
                + " SCH: " + jsonObject.get("scheduledTime") + " EST: " + jsonObject.get("estimatedTime") + " Status: " + jsonObject.get("remarks"));
    }

} catch (IOException | ParseException e) {
    e.printStackTrace();
}