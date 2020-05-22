/**
 * Creates a new PrintWriter, without automatic line flushing.
 *
 * @param  out        A character-output stream
 */
public PrintWriter (Writer out) {
    this(out, false);
}

/**
 * Creates a new PrintWriter.
 *
 * @param  out        A character-output stream
 * @param  autoFlush  A boolean; if true, the <tt>println</tt>,
 *                    <tt>printf</tt>, or <tt>format</tt> methods will
 *                    flush the output buffer
 */
public PrintWriter(Writer out,
                   boolean autoFlush) {
    super(out);
    this.out = out;
    this.autoFlush = autoFlush;
    lineSeparator = java.security.AccessController.doPrivileged(
        new sun.security.action.GetPropertyAction("line.separator"));
}