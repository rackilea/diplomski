public class FeedParser {
    public static void parse(String response) {
        try {
            JSONObject baseObject = new JSONObject(response);

            if (baseObject == null) {
                return;
            }

            // You need Time Series (Daily) so we are going directly there.
            // Time Series (Daily) is inside baseObject
            JSONObject timeSeriesObj = baseObject.optJSONObject("Time Series (Daily)");

            if (timeSeriesObj == null) {
                return;
            }

            // We have list of dates inside Time Series (Daily) object we can iterate it using keys
            Iterator<String> iterator = timeSeriesObj.keys();

            List<Map<String, String>> tickerData = new ArrayList<Map<String, String>>();

            while (iterator.hasNext()) {
                String key = iterator.next();

                if (key != null) {
                    HashMap<String, String> m = new HashMap<String, String>();

                    JSONObject finalObj = timeSeriesObj.optJSONObject(key);

                    m.put("1. open", finalObj.optString("1. open"));
                    m.put("2. high", finalObj.optString("2. high"));
                    m.put("3. low", finalObj.optString("3. low"));
                    m.put("4. close", finalObj.optString("4. close"));
                    m.put("5. volume", finalObj.optString("5. volume"));

                    tickerData.add(m);
                }
            }

            // Below commented code you can use if your want to store the date as well
//            Map<String, Metric> values = new HashMap<>();
//
//            while (iterator.hasNext()) {
//                String key = iterator.next();
//
//                if (key != null) {
//                    HashMap<String, String> m = new HashMap<String, String>();
//                    Metric metric = new Metric();
//
//                    JSONObject finalObj = timeSeriesObj.optJSONObject(key);
//
//                    metric.open = finalObj.optString("1. open");
//                    metric.high = finalObj.optString("2. high");
//                    metric.low = finalObj.optString("3. low");
//                    metric.close = finalObj.optString("4. close");
//                    metric.volume = finalObj.optString("5. volume");
//
//                    values.put(key, metric);
//                }
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}