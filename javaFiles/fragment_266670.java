try {
    premium = serviceCallEjb(anfrage);
}
catch (ServiceException e){
    processException(e, CcaLogManager.ERROR);
}
catch (Exception e){
    processException(e, CcaLogManager.WARNING);
}