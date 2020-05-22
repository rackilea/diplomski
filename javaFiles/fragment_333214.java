String[] addresses = request.getParameterValues("addresses");
for(String address : addresses) {
    System.out.println(address);
    JSONArray jArray = new JSONArray(address); //here!
    System.out.println(jArray.toString());
   //interate over array (like any other array) and do stuff, get the objects etc..
}