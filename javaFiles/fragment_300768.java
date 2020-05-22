//httpResponse is the output of google api
JSONObject jsonRespRouteDistance = new JSONObject(httpResponse)
                                        .getJSONArray("rows")
                                        .getJSONObject(0)
                                        .getJSONArray ("elements")
                                        .getJSONObject(0)
                                        .getJSONObject("distance");

String distance = jsonRespRouteDistance.get("text").toString();

/* 
* For distance, below is only partial solution as the 
* output to string destination_addr will contain square brackets [] and double codes ""
* Eg. [ "1600 Pennsylvania Avenue, Hagerstown, MD 21742, USA" ]
* 
*/
String destination_addr = new JSONObject(httpResponse)
                            .get("destination_addresses")
                            .toString();