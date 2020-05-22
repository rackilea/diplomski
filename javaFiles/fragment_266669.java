try {
    premium = serviceCallEjb(anfrage);
}
catch (Exception e){
    processException(e, e instanceof ServiceException?
                     CcaLogManager.ERROR : CcaLogManager.WARNING);
}