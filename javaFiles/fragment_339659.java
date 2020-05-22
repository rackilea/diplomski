@RequestMapping(value = "ajaxtest", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody
ResponseModel getTime(@RequestBody  ResponseModel editUserRequest) {


    String result = editUserRequest.getModel()+editUserRequest.getPrice()+editUserRequest.getProducer();
    //String result = "editUserRequest";
    //System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
    return editUserRequest;
}