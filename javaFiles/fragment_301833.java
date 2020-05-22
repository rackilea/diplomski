public class MyXmlRpcServlet extends XmlRpcServlet {
    @Override
    protected XmlRpcHandlerMapping newXmlRpcHandlerMapping()
        throws XmlRpcException {
        PropertyHandlerMapping mapping = (PropertyHandlerMapping) super
            .newXmlRpcHandlerMapping();
        XmlRpcSystemImpl.addSystemHandler(mapping);
        return mapping;
}
}