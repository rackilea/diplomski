Document retDoc;
byte[] c14nOutputbytes;
DocumentBuilderFactory factory;
DocumentBuilder parser;

// CANONICALIZE THE ORIGINAL DOM
c14nOutputbytes = Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_WITH_COMMENTS).canonicalizeSubtree(inXMLDoc.getDocumentElement());

// PARSE THE CANONICALIZED BYTES (IF YOU WANT ANOTHER DOM) OR JUST USE THE BYTES
factory = DocumentBuilderFactory.newInstance();
factory.set ... // SETUP THE FACTORY
parser = factory.newDocumentBuilder();
// REPARSE TO GET ANOTHER DOM WITH THE ATTRIBUTES IN ALPHA ORDER
ByteArrayInputStream bais = new ByteArrayInputStream(c14nOutputbytes);
retDoc = parser.parse(bais);