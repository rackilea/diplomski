String url = "http://10.60.74.134:9200/logstash-2015.04.09/_search?pretty'-d'";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "{\"facets\":{\"0\":{\"date_histogram\":{\"field\":\"@timestamp\",\"interval\":\"5m\"},\"global\":true,\"facet_filter\":{\"fquery\":{\"query\":{\"filtered\":{\"query\":{\"query_string\":{\"query\":\"*\"}},\"filter\":{\"bool\":{\"must\":[{\"range\":{\"@timestamp\":{\"from\":1428558001338,\"to\":1428579601338}}},{\"terms\":{\"_type\":[\"akaoatg-monitoring\"]}}]}}}}}}}},\"size\":0}";