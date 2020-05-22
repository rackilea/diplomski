int paramIndex = 1;

if( title != null && title.trim().length() > 0 ) {
    pst.setString( paramIndex++, title );  
}
if( isbn != null && isbn.trim().length() > 0 ) {
    pst.setString( paramIndex++, isbn );  
}
if( author != null && author.trim().length() > 0 ) {
    pst.setString( paramIndex++, author );  
}