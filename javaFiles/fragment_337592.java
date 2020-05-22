@RequestMapping(value = "/save" , method = RequestMethod.POST)
public RestWrapperDTO saveScheduledAlert(@Valid ScheduledAlertForm scheduledAlertForm, BindingResult bindingResult) {
    StringBuilder jsonString = new StringBuilder();

    if(bindingResult.hasErrors()){
        RestErrorDTO errorDTO = new RestErrorDTO();
        // fill map with errors here
        return errorDTO;
    } else {
        RestWrapperDTO wrapperDTO = new RestWrapperDTO();
        wrapperDTO.setSuccess(true);
        return wrapperDTO;
    }
}