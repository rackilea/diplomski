boolean empty = true;
while( rs.next() ) {
    // ResultSet processing here
    empty = false;
}

if( empty ) {
    // Empty result set
}