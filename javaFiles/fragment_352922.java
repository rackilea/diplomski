/**
 * Opens a file, with the specified name, for writing.
 * @param name name of file to be opened
 */
private native void open(String name) throws FileNotFoundException;

/**
 * Opens a file, with the specified name, for appending.
 * @param name name of file to be opened
 */
private native void openAppend(String name) throws FileNotFoundException;

/**
 * Writes the specified byte to this file output stream. Implements 
 * the <code>write</code> method of <code>OutputStream</code>.
 *
 * @param      b   the byte to be written.
 * @exception  IOException  if an I/O error occurs.
 */
public native void write(int b) throws IOException;