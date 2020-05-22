@InitBinder("invoicedata")
protected void invoiceDataBinder(WebDataBinder binder) {
    binder.setValidator(invoiceFormValidator);
}

@InitBinder("contractor")
protected void contractorDataBinder(WebDataBinder binder) {
    binder.setValidator(personFormValidator);
}