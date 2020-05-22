public OMElement myService ()
{
    OMFactory fac = OMAbstractFactory.getOMFactory();
    OMNamespace omNs = fac.createOMNamespace("", "");
    OMElement codes = fac.createOMElement("codes", omNs);
    while(SOME_CONDITION)
    {
       OMElement code = fac.createOMElement("code", null, codes);
       OMAttribute value = fac.createOMAttribute("value", null, tempStr);
       code.addAttribute(value);
    }
    return(codes); 
}