/**
* Returns an input stream that reads from this open connection.
*
* @return     an input stream that reads from this open connection.
* @exception  IOException              if an I/O error occurs while
*               creating the input stream.
* @exception  UnknownServiceException  if the protocol does not support
*               input.
*/
public InputStream getInputStream() throws IOException {
    throw new UnknownServiceException("protocol doesn't support input");
}