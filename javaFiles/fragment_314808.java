MbMessage outMessage = new MbMessage();
MbMessageAssembly outAssembly = new MbMessageAssembly(assembly, outMessage);
MbElement omroot = outMessage.getRootElement();
MbElement xmlnsc = omroot.createElementAsLastChild ("XMLNSC");
MbElement valueEl = xmlnsc.createElementAsFirstChild(MbElement.TYPE_VALUE, "VALUE", 
            new String ((byte[])message.getRootElement ().getFirstElementByPath("XMLNSC/article/titre").getValue()));

// And use getFirstElementByPath field by field not trying to display all of it like text

out.propagate(outAssembly);