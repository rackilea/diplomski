String requestURI = "http://myserver:9080/ReportingManager/service/repManHealth/importHistoryTrafficLightStatus.json";
    URL url = new URL(requestURI);
    URLConnection conn = url.openConnection();
    InputStream in = conn.getInputStream();
    BufferedReader rd = new BufferedReader(new InputStreamReader(in));
    StringBuffer sb = new StringBuffer();
    String line = null;
    while ((line = rd.readLine()) != null) {
        sb.append(line);
    }
    rd.close();