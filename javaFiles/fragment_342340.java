@PostConstruct
public void init() {
    try {
        InputStream is = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/META-INF/MANIFEST.MF");
        manifest = new Manifest();
        manifest.read(is);
    } catch (IOException ioe) {
        logger.error("Unable to read the Manifest file from classpath.", ioe);
    }
}