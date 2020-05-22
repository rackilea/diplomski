@RequestMapping(value = "url",
      consumes = { "application/json" }, 
      produces = {"application/json" },
      method = RequestMethod.POST)
public MyResponse getMyData(
      @RequestBody MyRequest myRequest, BindingResult result, CustomObject obj){
    MyCustomValidator validator = MyCustomValidator();
    validator.validate(myRequest, result);

    if (result.hasErrors()){
      // do something
    }

    return new MyResponse();
}