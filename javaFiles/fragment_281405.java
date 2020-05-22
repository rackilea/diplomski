/**
 * Creates a new input stream with the specified buffer size.
 * @param in the input stream
 * @param size the input buffer size
 * @exception IOException if an I/O error has occurred
 * @exception IllegalArgumentException if size is <= 0
 */
public GZIPInputStream(InputStream in, int size) throws IOException {
super(in, new Inflater(true), size);
    usesDefaultInflater = true;
        readHeader(in);
}