/**
 * Closes this input stream and releases any system resources associated
 * with the stream.
 * @exception IOException if an I/O error has occurred
 */
public void close() throws IOException {
    if (!closed) {
        super.close();  
        eos = true;
        closed = true;
    }
}