/**
 * Sets the text leading.
 *
 * @param leading The leading in unscaled text units.
 * @throws IOException If there is an error writing to the stream.
 */
public void setLeading(double leading) throws IOException
{
    writeOperand((float) leading);
    writeOperator("TL");
}

/**
 * Move to the start of the next line of text. Requires the leading to have been set.
 *
 * @throws IOException If there is an error writing to the stream.
 */
public void newLine() throws IOException
{
    if (!inTextMode)
    {
        throw new IllegalStateException("Must call beginText() before newLine()");
    }
    writeOperator("T*");
}