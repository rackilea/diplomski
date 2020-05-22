public PlatformManagedBean() {
    super();
    if(platformService == null){
        WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        platformService = ctx.getBean(PlatformService.class);
    }

}