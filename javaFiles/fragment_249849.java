// Instantiate XPath variable
XPath xpath = XPathFactory.newInstance().newXPath();
// Define the exact XPath expressions you want to get data for:
XPathExpression name     = xpath.compile("//top/CRAWL/NAME/text()");
XPathExpression price    = xpath.compile("//top/CRAWL/PRICE/text()");
XPathExpression desc     = xpath.compile("//top/CRAWL/DESC/text()");
XPathExpression prod_img = xpath.compile("//top/CRAWL/PROD_IMG/text()");
XPathExpression url      = xpath.compile("//top/CRAWL/URL/text()");