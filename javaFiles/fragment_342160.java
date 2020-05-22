// getContent() returns the complete text to strip.
//
String s = getContent();

// Find the start of the XML content using the <?xml prefix.
//
int xmlIndex = s.indexOf( "<?xml" );

// Strip the non-XML header.
//
s = s.substring( xmlIndex );

// Find the last closing angle-bracket; should indicate end of the XML.
//
xmlIndex = s.lastIndexOf( ">" );

// Strip everything after the closing angle-bracket.
//
s = s.substring( 0, xmlIndex );