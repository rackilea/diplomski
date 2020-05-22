public Vector<VariableBinding> getVariables(Document document){ 

Vector<VariableBinding> variables = new Vector<VariableBinding>();

Element root = document.getRootElement();
Element body = root.getChild("body");
Element oidsElement = body.getChild("variables");

for (Object ovb: oidsElement.getChildren("variableBinding")) {

    Element vb = (Element) ovb;
    Variable var = new OctetString(vb.getChild("OID").getText());
    OID oidObj = new OID(vb.getChild("variable").getText());

    VariableBinding v = new VariableBinding(oidObj,var);
    variables.add(v);
}
return variables;
}