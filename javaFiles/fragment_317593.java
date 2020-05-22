/**
 * Creates a new PrintWriter from an existing OutputStream.  This
 * convenience constructor creates the necessary intermediate
 * OutputStreamWriter, which will convert characters into bytes using the
 * default character encoding.
 *
 * @param  out        An output stream
 * @param  autoFlush  A boolean; if true, the <tt>println</tt>,
 *                    <tt>printf</tt>, or <tt>format</tt> methods will
 *                    flush the output buffer
 *
 * @see java.io.OutputStreamWriter#OutputStreamWriter(java.io.OutputStream)
 */
public PrintWriter(OutputStream out, boolean autoFlush) {
this(new BufferedWriter(new OutputStreamWriter(out)), autoFlush);