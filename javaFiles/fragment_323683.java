String JSON_DATA;

String streetAddress = "";
String surname       = "";

int tempPos = JSON_DATA.indexOf("StreetAddress");
streetAddress = JSON_DATA.substring(tempPos+14)
int deliminator = streetAddress.indexOf(",");
streetAddress = streetAddress.substring(0,deliminator);