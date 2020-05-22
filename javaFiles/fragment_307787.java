String[] stringArray =  responseFirst.split(",")
for(String kvPair: stringArray) {
String[] kv = kvPair.split(":");
String key = kv[0].substring(1).replace('"', '\u0020').trim();
String value = kv[1].substring(1, kv[1].length() - 1).replace('"', '\u0020').trim();

// Now do with key whatever you want with key and value...
if(key.equals("somekey")) {
   // Do something with value if the key is "somekey"...
}
}