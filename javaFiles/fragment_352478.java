if (bindingResult.hasErrors()) {
    ModelAndView modelAndView = this.initFormModelAndView();
    List<String> errors = buildErrorMessages(bindingResult);
    modelAndView.addObject(CSV_MODEL_ATTRIBUTE, csvUploadForm);
    modelAndView.addObject("errors", errors);
    return modelAndView;
}