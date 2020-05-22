for (Object obj : jsonArray) {
    JSONObject jsonObject = (JSONObject) obj;
    String metricValue = (String) jsonObject.get(metricKey);
    OptionalLong metricDate = parseDate(jsonObject);
    metricDate.ifPresent(d -> metricsList.add(new Metric(metricValue, d));           
}