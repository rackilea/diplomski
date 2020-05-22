@RequestMapping(value = "module/manage", method = RequestMethod.POST)
public String processSubmit(@RequestParam(value = "errors", required = false) String   ignoredExceprions, BindingResult result,
                            SessionStatus status) {
    boolean successSave = false;
    GlobalProperty glProp = Context.getAdministrationService().getGlobalPropertyObject(
        ErrorLoggingConstants.ERRROR_LOGGING_GP_IGNORED_EXCEPTION);
    if (glProp != null) {
        glProp.setPropertyValue(ignoredExceprions);
        GlobalProperty saved = Context.getAdministrationService().saveGlobalProperty(glProp);
        System.out.println(saved.getPropertyValue());
                    if (saved != null && saved.getPropertyValue().equals(ignoredExceprions)) {
            successSave = true;
        }
    }
            status.setComplete();
    return "module/manage";
}