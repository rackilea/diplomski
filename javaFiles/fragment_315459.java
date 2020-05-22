public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    String test = "idStation=6107AAE80593E4B2&timestamp=1558524847&pm1=0.800&pm2_5=1.510&pm10=2.650&temperature=22.380"
            + "&humidity=40.379&pressure=93926.656&luminosity=131&coC=0.440923810000&no2C=0.000000000000&o3C=8.210327100000&"
            + "batteryLevel=27&batteryCurrent=0&baterryVolts=3.63";
    String[] result = test.split("&");
    Map<String, String> map = new HashMap<String, String>();
    for (String string : result) {
        String[] str = string.split("=");
        map.put(str[0], str[1]);
    }
    double pressure = Double.valueOf(map.get("pressure"));
    double no2C = Double.valueOf(map.get("no2C"));
    double tempreture = Double.valueOf(map.get("temperature"));
    double o3C = Double.valueOf(map.get("o3C"));
    double cOC = Double.valueOf(map.get("coC"));
    System.out.println("Pressure:: "+pressure+" , no2c :: "+no2C+", tempreture:: "+tempreture+" ,o3C:: "+o3C+" ,coC:: "+cOC);
}