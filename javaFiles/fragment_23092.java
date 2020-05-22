JClass importJAXBContext = codeModel.ref(javax.xml.bind.JAXBContext.class);
    JVar varJc = block.decl(importJAXBContext, "jc");

    JClass naturalLangClassRef = codeModel.ref(NaturalLanguageUsage.class);

    JInvocation invokeJAXBContext = importJAXBContext.staticInvoke("newInstance");
    invokeJAXBContext.arg(naturalLangClassRef.dotclass());

    block.assign(varJc, invokeJAXBContext);