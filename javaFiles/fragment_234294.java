private static JAXBContext createJaxbContext() {
    try {
        return JAXBContext.newInstance(CompletedAssessmentInstance.class);
    } catch (JAXBException ex) {
        LOGGER.error("Failed to create JAXB context: ", ex);
        return null;
    }
}