Document newDocument = Jsoup.parse(htmlString, StringUtils.EMPTY, Parser.htmlParser());
newDocument.outputSettings().escapeMode(EscapeMode.base);
/**
 * Need CharEncoding.US_ASCII and not UTF-8 so the special characters will be encoded properly,
 * but representation of such will change. For instance: &mdash; will be encoded as &#8212;
 */
newDocument.outputSettings().charset(CharEncoding.US_ASCII);
newDocument.outputSettings().prettyPrint(false); // this will make sure that it will not add line breaks