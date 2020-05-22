this.uniqueImageFileName = getOrGenerateItSomehow();
byte[] imageContent = convertBase64ToByteArraySomehow();
ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
ServletContext sc = (ServletContext) ec.getContext();
File image = new File(sc.getRealPath("/images"), uniqueImageFileName);
// Write byte[] to FileOutputStream on that file the usual way (and close!)