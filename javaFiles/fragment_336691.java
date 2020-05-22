/**
 * Write the line separator value to the output stream.
 * @throws IOException
 *             If there is a problem writing out the lineseparator to the document.
 */
protected void writeLineSeparator( ) throws IOException
{
    output.write(getLineSeparator());
}