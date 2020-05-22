while ((num_read = stream.read(buf, 0, buf.length)) >= 0) {
    if ( shouldStop ) {
        break;
    }
   ...
}