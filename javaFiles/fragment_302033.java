// get the json
String jsonStr = sh.makeServiceCall(url, ServiceHandler.POST, params);

// get the object from the json
ObjectMapper mapper = new ObjectMapper();
User user = mapper.readValue(jsonStr, User.class);

// get user.data.companyInfo.name
String name = null;
if(user != null && user.getData() != null && user.getData().getCompanyInfo() != null)
    name = user.getData().getCompanyInfo().getName();