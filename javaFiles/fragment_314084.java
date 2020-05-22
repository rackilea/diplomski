JspFactory  factory     = JspFactory.getDefaultFactory();
PageContext pageContext = factory.getPageContext(
this,
request,
response,
null,  // errorPageURL
false, // needsSession
JspWriter.DEFAULT_BUFFER,
true   // autoFlush
);