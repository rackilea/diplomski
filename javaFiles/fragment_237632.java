String latLong = "lat/lng: (55.94569390835889,-3.190410055779333)";
 Pattern patte = Pattern.compile("-?[0-9]+(?:.[0-9]+)?");
 Matcher matcher = patte.matcher(latLong);
 while (matcher.find()) {
      System.out.println(Double.parseDouble(matcher.group()));
 }