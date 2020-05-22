public void createCmwUserSession() throws IOException {

    if (!(marketVo.getAbsoluteUrl() != null && marketVo.getAbsoluteUrl().equals(absoluteUrlToRedirect))) {
        logger.info("---WILL REDIRECT TO ABS URL: " + absoluteUrlToRedirect);
        FacesContext.getCurrentInstance().getExternalContext().redirect(absoluteUrlToRedirect);
    }
}