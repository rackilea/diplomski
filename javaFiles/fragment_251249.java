public String cb1_action() {

    try{
    FacesContext fctx = FacesContext.getCurrentInstance(); 
    BindingContext bindingContext = BindingContext.getCurrent();
    DCDataControl dc = bindingContext.findDataControl("AppModuleAMDataControl");
    AppModuleAMImpl am = (AppModuleAMImpl)dc.getDataProvider();


    am.criarTesteComEntityObject();
    }
    catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}