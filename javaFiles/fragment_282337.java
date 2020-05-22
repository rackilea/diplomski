// Adding FOP eventListeners
FOUserAgent userAgent = Factory.getInstance().getFactory().newFOUserAgent();
userAgent.getEventBroadcaster().addEventListener(getInvalidPropertyEventListener());
Fop fop = Factory.getInstance().getFactory().newFop(MimeConstants.MIME_PDF, userAgent, output);

// Transform the FO to PDF
Result res = new SAXResult(fop.getDefaultHandler());
Source src = new StreamSource(foSource);
Transformer transformer = TRANSFACTORY.newTransformer();
transformer.transform(src, res);