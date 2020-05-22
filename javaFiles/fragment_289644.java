FileOutputStream fileOutputStream = new FileOutputStream(outXmlFile);
XMLStreamWriter defaultWriter = factory.createXMLStreamWriter(fileOutputStream, encoding);
IndentingXMLStreamWriter writer = new IndentingXMLStreamWriter(defaultWriter);
writer.setIndentStep("  ");
try
{
    writer.writeStartDocument(encoding, "1.0");

    if (stylesheet != null)
    {
        writer.writeProcessingInstruction("xml-stylesheet", "type='text/xsl' href='" + stylesheet + "'");
        writer.writeCharacters("\n");
    }


    writer.writeStartElement(TAG_ROOT);
    writer.writeAttribute(TAG_OBJECT_TYPE, rootObject.getClass().getSimpleName());

    ...

    writer.writeEndElement();
    writer.writeEndDocument();
} 
finally
{
    writer.flush();
    writer.close();
    fileOutputStream.close();
}