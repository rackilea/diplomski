CSSResolver cssResolver = new StyleAttrCSSResolver();
CssFile cssFile = XMLWorkerHelper.getCSS(new ByteArrayInputStream(CSS.getBytes()));
cssResolver.addCss(cssFile);
// HTML
HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
// Pipelines
ElementList elements = new ElementList();
ElementHandlerPipeline pdf = new ElementHandlerPipeline(elements, null);
HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
// XML Worker
XMLWorker worker = new XMLWorker(css, true);
XMLParser p = new XMLParser(worker);
p.parse(new ByteArrayInputStream(sb.toString().getBytes()));