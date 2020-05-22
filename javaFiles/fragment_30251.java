@PostMapping(Constants.Endpoints.**)
public ShowParametersResponse getParams(@RequestBody  ShowParametersRequest showParametersRequest) {

     List<String> constStringList = Arrays.asList("./ManagedObjects/Phone/Manufacturer",
                    "./ManagedObjects/**something",
                    "./ManagedObjects/**something");    

    showParametersRequest.setData(constStringList);  
    log.info("Got request as : " + showParametersRequest);
    returnMapper.getParams(showParametersRequest);
}