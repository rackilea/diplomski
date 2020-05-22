String[] rawString = data.replace(" ", "").split(":");
if(rawString.length>1){
  String apiCallKey = rawString[0];
  String apiCallVal = rawString[1];
  callAPI(apiCallKey,apiCallVal);
}