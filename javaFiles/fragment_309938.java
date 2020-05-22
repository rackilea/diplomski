StringBuilder sb = new StringBuilder();

int c;

while ( (( c = inputStream.read() ) >= 0) && (c != 0x0a /* <LF> */) ) {
  if ( c != 0x0d /* <CR> */ ) {
    sb.append( (char)c );
  } else {
    // Ignore <CR>.
  }
}

return sb.toString();