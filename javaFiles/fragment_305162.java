if ((length = request.getContentLength()) != -1)
{
    received = new byte[length];
    int pos = 0;
    do {
        int read = requestStream.read(received, pos, length-pos);

        // check for end of file or error
        if (read == -1) {
            break;
        } else {
            pos += read;
        }
    } while (pos < length);
}