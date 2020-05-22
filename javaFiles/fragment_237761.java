qname = removeNamespaces ? new QName(lname) : new QName(qname.getNamespaceURI(), lname);
    final AxisServer server = new AxisServer();
    final BeanSerializer ser = new BeanSerializer(obj.getClass(), qname, typeDesc);
    final SerializationContext ctx = new SerializationContext(outStr, new MessageContext(server));
    ctx.setSendDecl(false);
    ctx.setDoMultiRefs(false);
    ctx.setPretty(prettyPrint);