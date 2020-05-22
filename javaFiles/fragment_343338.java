String menuNameNotBlanked = menuName == null ? "" : menuName.replace(" ","_");
    String formPathNotBlanked = formPath == null ? "" : formPath.replace(".xhtml","").replace("/","_");
    String helpPath = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath(HELP_FILE_PATH);

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    URL contextURL = new URL(request.getScheme(),request.getServerName(),request.getServerPort(),request.getContextPath());
    URL helpURL = new URL(contextURL.toString()+ "/" + HELP_FILE_PATH + AddLeadString(menuNameNotBlanked+formPathNotBlanked,"#"));
    RequestContext.getCurrentInstance().execute("window.open('" + helpURL + "')");