String reply = in.readUTF();
if( "http://localhost:8181".equalsIgnoreCase( reply ) ||
    "http://localhost:8181/pic".equalsIgnoreCase( reply ) ){
    // success
} else {
    // failure
}
in.close();
// etc