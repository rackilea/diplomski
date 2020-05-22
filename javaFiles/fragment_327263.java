// Please refactor.
String[] paramPart = url.split("?");
String[] params = paramPart[1].split("&");
Map<String, String> paraMap = new HashMap<>();
for(int i=0; i<params.length; i++) {
  String[] keyValue;
  if(params[i].contains("=")) {
    keyValue = params[i].split("=");
    paraMap.put(keyValue[0], keyValue[1]);
  } else {
    params[i-1] = params[i-1] + "&" + params[i];
    keyValue = params[i-1].split("=");
    paraMap.put(keyValue[0], keyValue[1]);
  }
}