public static XMLInputFactory getXMLInputFactory(MessageContext ctx)
{
    if (ctx == null) return xmlInputFactory;

    Object inFactoryObj = ctx.getContextualProperty(XFire.STAX_INPUT_FACTORY);

    if (inFactoryObj instanceof XMLInputFactory)
    {
        return (XMLInputFactory) inFactoryObj; 
    }
    else if (inFactoryObj instanceof String)
    {
        String inFactory = (String) inFactoryObj;
        XMLInputFactory xif = (XMLInputFactory) factories.get(inFactory);
        if (xif == null)
        {
            xif = (XMLInputFactory) createFactory(inFactory, ctx);
            configureFactory(xif,ctx);
            factories.put(inFactory, xif);
        }
        return xif;
    }

    if(!inFactoryConfigured){
        configureFactory(xmlInputFactory,ctx);
        inFactoryConfigured=true;
    }



    return xmlInputFactory;
}