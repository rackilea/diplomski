DOMImplementation imp = SVGDOMImplementation.getDOMImplementation();
DocumentType type = imp.createDocumentType(SVGConstants.SVG_PUBLIC_ID, SVGConstants.SVG_SYSTEM_ID, null);
Document svgDoc = imp.createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", type);
JSVGCanvas canvas = new SVGCanvas(new SVGUserAgentAdapter(), true, true);
canvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
canvas.setSVGDocument(svgDoc);