@Autowired
private Gson gson;

@RequestMapping(value = "/path/info", method = RequestMethod.POST)
public String myMethod(@RequestParam(value = "data") String data,
                       Model model,
                       @Valid MyCustomObject myObj,
                       BindingResult result) {
    //myObj does not contain any validation information.
    //we are just using it as as bean to take advantage of the spring mvc framework.
    //data contains the json string.
    myObj = gson.fromJson(data, MyCustomObject.class);

    //validate the object any way you want. 
    //Simplest approach would be to create your own custom validator 
    //to do this in Spring or even simpler would be just to do it manually here.
    new MyCustomObjValidator().validate(myObj, result);

    if (result.hasErrors()) {
        return myErrorView;
    }
    return mySuccessView;
}