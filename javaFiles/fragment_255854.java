@RequestMapping(value="addFlightDetails", method = RequestMethod.POST)

 public void addOfferTest(HttpServletRequest request, HttpServletResponse 
 response,@RequestBody String json){

  JSONObject mainObject=new JSONObject(json);
  JSONObject flightdetails=mainObject.getJSONObject("flight_details");
  String flight_from=flightdetails.getString("flight_from");
  String flight_from=flightdetails.getString("flight_from");
  System.out.println(flight_from);
  System.out.println(flight_to);

 }