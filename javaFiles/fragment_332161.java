/**
 * unmarshallFromTemplate.  Where jaxbElement has not been
 * unmarshalled yet, this is more efficient (3 times
 * faster, in some testing) than calling
 * XmlUtils.marshaltoString directly, since it avoids
 * some JAXB processing.  
 * 
 * @param mappings
 * @throws JAXBException
 * @throws Docx4JException
 * 
 * @since 3.0.0
 */
public void variableReplace(java.util.HashMap<String, String> mappings) throws JAXBException, Docx4JException {

    // Get the contents as a string
    String wmlTemplateString = null;
    if (jaxbElement==null) {

        PartStore partStore = this.getPackage().getSourcePartStore();
        String name = this.getPartName().getName();
        InputStream is = partStore.loadPart( 
                name.substring(1));
        if (is==null) {
            log.warn(name + " missing from part store");
            throw new Docx4JException(name + " missing from part store");
        } else {
            log.info("Lazily unmarshalling " + name);

            // This seems to be about 5% faster than the Scanner approach
            try {
                wmlTemplateString = IOUtils.toString(is, "UTF-8");
            } catch (IOException e) {
                throw new Docx4JException(e.getMessage(), e);
            }
        }

    } else {

        wmlTemplateString = XmlUtils.marshaltoString(jaxbElement, true, false, jc);

    }

    // Do the replacement
    jaxbElement = (E)XmlUtils.unwrap(
                        XmlUtils.unmarshallFromTemplate(wmlTemplateString, mappings, jc));

}