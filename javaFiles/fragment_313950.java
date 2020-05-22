public void map(Object key, Text line, Context context) throws IOException,
      InterruptedException {

    InetAddress ipAddress = InetAddress.getByName(address.getHostAddress());
    CityResponse response = null;
    try {
      response = reader.city(ipAddress);
    } catch (GeoIp2Exception ex) {
      ex.printStackTrace();
      return;
    }

    Country country = response.getCountry();
    String count = country.getName(); // 'US'

    if (country.getName() == null) {
      return;
    }