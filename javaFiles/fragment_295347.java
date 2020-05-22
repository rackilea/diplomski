public StreamedContent getImage() {
     FacesContext context = FacesContext.getCurrentInstance();
     HttpServletRequest myRequest = (HttpServletRequest) context.getExternalContext().getRequest();
     String imageID = (String) myRequest.getParameter("imageID");
     return new DefaultStreamedContent(new ByteArrayInputStream(themeFacade.find(Long.parseLong(imageID)).getImage()));
}