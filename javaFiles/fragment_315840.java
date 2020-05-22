JSONObject tempObject = arrWeatherList.getJSONObject(i).getJSONObject("temp");

 String temperature = changeTemp(tempObject.get("day").toString());

 private String changeTemp(String x) {
    Double celsius = Double.parseDouble(x) - 273.0;
    Integer i = celsius.intValue();
    return String.valueOf(i);
}