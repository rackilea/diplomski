@PostMapping(params = "_action_preview_pdf", produces = MediaType.APPLICATION_PDF_VALUE)
public Object getTemplatePDF(@Valid @ModelAttribute(COMMAND_NAME) RxTemplateConfiguration configuration,
                                         BindingResult result) {

    if(result.hasErrors()){
        return VIEW_FORM;  //Error fixed.
    }

    ....

    return new ResponseEntity<>(prescriptionHelper.getTemplatePdf(configuration), headers, HttpStatus.OK);

}