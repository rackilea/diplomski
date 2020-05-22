@RequestMapping(method = RequestMethod.POST, 
        value = "/url", params = "session_type=typeX")
public String handleTypeX(@RequestBody @ModelAttribute TypeX typeX){
    //TODO implement
}

@RequestMapping(method = RequestMethod.POST,
        value = "/url", params = "session_type=typeY")
public String handleTypeY(@RequestBody @ModelAttribute TypeY typeY){
    //TODO implement
}