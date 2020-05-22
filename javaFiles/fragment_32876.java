@RequestMapping(value = "url1", method = RequestMethod.POST,consumes="multipart/form-data")
    public ModelAndView createNewMerchantAccount(@ModelAttribute("attribute1") ModelName modelParam,BindingResult result, Map<String, Object> models) throws IOException{

        //Do Something
 if(result.hasErrors()) {
               System.out.println("Result Error Occured"+result.getAllErrors());
            }
        return new ModelAndView("successpage");

    }