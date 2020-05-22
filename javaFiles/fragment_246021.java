for (Object obj : jsonArray) {
    try {
        JSONObject jsonObject = (JSONObject) obj;
        String metricValue = (String) jsonObject.get(metricKey);
        Long metricDate = parseDate(jsonObject);
        metricsList.add(new Metric(metricValue, metricDate));
    } catch (java.text.ParseException e) {         
        log.error("Error when parsing JSON", e);
    }
}