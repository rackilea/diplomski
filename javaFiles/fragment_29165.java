Public string MyFunction(){
 if(eLead.GPMIR_fld_codigoOrigen__c!='09'){
    if(u.Contact != null && u.Contact.Account != null && rt == 'Agencia'){
        Return u.Contact.Account.Id;
    }
}
Return null;
}```
//Then in main(), eLead.GPMIR_fld_assignAgency__c = MyFunction()