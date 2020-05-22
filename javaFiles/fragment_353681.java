// we need to get the DOMImplementation from the Document - if header is an
// Element then do:
DOMImplementationLS ls =
    (DOMImplementationLS)header.getOwnerDocument().getImplementation();
// if header is already a Document then it's just
//DOMImplementationLS ls =
//    (DOMImplementationLS)header.getImplementation();

// LSInput represents the source from which the XML to be parsed will be taken
LSInput input = ls.createLSInput();
input.setStringData(Titleproper);

// LSParser does the parsing
LSParser parser = ls.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);

// parseWithContext(input, context, action) parses the fragment given by input
// and inserts the results at a position relative to the node "context".  In this
// case we use ACTION_REPLACE_CHILDREN which means remove all the child nodes
// (if any) from the context node and replace them with the result of the parse.
// Alternative actions include replacing the context node entirely, inserting
// the parse results as siblings before or after the context node, etc.
parser.parseWithContext(input,
    header.getElementsByTagName("titleproper").item(0),
    LSParser.ACTION_REPLACE_CHILDREN);