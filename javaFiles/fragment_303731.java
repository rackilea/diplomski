public class ExceptionHandlingFaceletViewHandler extends FaceletViewHandler { 
  ...

  protected void handleRenderException( FacesContext context, Exception exception ) throws IOException, ELException, FacesException {  
    try {
      if( context.getViewRoot().getViewId().matches( ".*/error.jsf" ) ) {
        /*
         * This is to protect from infinite redirects if the error page itself is updated in the
         * future and has an error
         */
        LOG.fatal("Redirected back to ourselves, there must be a problem with the error.xhtml page", exception );
        return;
      }

      String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
      getHttpResponseObject().sendRedirect( contextPath + "/error" );
    }
    catch( IOException ioe ) {
      LOG.fatal( "Could not process redirect to handle application error", ioe );
    }
  }

  private HttpServletResponse getHttpResponseObject() {
    return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
  }
}