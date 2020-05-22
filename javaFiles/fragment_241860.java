Document doc = factory.createSVGDocument(f.toURI().toString());
UserAgent userAgent = new UserAgentAdapter();
DocumentLoader loader = new DocumentLoader(userAgent);
BridgeContext ctx = new BridgeContext(userAgent, loader);
ctx.setDynamicState(BridgeContext.DYNAMIC);
GVTBuilder builder = new GVTBuilder();
builder.build(ctx, doc);