String rtf = [your document rich text];
BufferedReader input = new BufferedReader(new StringReader(rtf));

RTFEditorKit rtfKit = new RTFEditorKit();
StyledDocument doc = (StyledDocument) rtfKit.createDefaultDocument();
rtfEdtrKt.read( input, doc, 0 );
input.close();

HTMLEditorKit htmlKit = new HTMLEditorKit();       
StringWriter output = new StringWriter();
htmlKit.write( output, doc, 0, doc.getLength());

String html = output.toString();