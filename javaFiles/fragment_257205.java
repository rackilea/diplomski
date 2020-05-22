Map<String,String> yourMap; //imagine is your input 
                            //"latitude":"25°21 N",
                            //"longitude":"55°23 E"

String latitude = yourMap.get("latitude");
String hour = latitude.split("º")[0];
String minute = latitude.split("º")[1].split(" ")[0];

// This is a very ugly way to parse it, better do with regular expressions, 
// but I'm not an expert on them and cannot figure them.


//Parse result
String hour = "25";
String minute = "21";
String second = "0";

//Formula
double result = Integer.intValue(hour) + 
                Integer.intValue(minute) / 60 + 
                Integer.intValue(second) / 3600;