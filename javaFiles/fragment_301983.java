@RequestMapping(value = "/mobile_getcountrylist", method = RequestMethod.GET, produces = {"application/x-javascript"})
    @ResponseBody   
    public Object mobile_getcountrylist( @RequestParam("callback") String jsonpCallback) {

        System.out.println(API_TAG + "Request recevied to get CountryList");    
        CountryList countryList = avlMobileAPIService.getCountryList("en");
        //countryList.setJsonCallback(jsonpCallback); 
        return convertToJsonP(countryList,jsonpCallback);
    }

    private String convertToJsonP(Object o,String jsonpCallback){
        String outputmessage=null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            outputmessage=mapper.writeValueAsString(o);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(outputmessage!=null){
            outputmessage=jsonpCallback + "(" + outputmessage + ")";
        }
        return outputmessage;   
    }