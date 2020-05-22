public static class MyContextFactory implements JAXBContextFactory
{
    @Override
    public JAXBRIContext createJAXBContext(final SEIModel sei,
            @SuppressWarnings("rawtypes") final List<Class> classesToBind, final List<TypeReference> typeReferences)
            throws JAXBException
    {
        JAXBRIContext context = JAXBContextFactory.DEFAULT.createJAXBContext(sei, classesToBind, typeReferences);
        return new MyJaxwsContext(context);
    }
}