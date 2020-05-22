XPathEngine engine = new JAXPXPathEngine();
engine.setNamespaceContext(new HashMap<String, String>(1) {{
    put(DEFAULT_NS_PREFIX, "uri:foo");
}});
assertEquals("value", engine.evaluate("/:a/:b",
             Input.fromString("<a xmlns=\"uri:foo\"><b>value</b></a>").build()));