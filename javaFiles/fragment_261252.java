StringBuilder sql = new StringBuilder( 1024 );
sql.append( " SELECT * FROM booklist " );
String whereCondition = "";
if( title != null && title.trim().length() > 0 ) {
    whereCondition += " title = ?";
}
if( isbn != null && isbn.trim().length() > 0 ) {
    whereCondition += (whereCondition.length() > 0 ? " AND " : "" );
    whereCondition += " isbn = ?";
}
if( author != null && author.trim().length() > 0 ) {
    whereCondition += (whereCondition.length() > 0 ? " AND " : "" );
    whereCondition += " author = ?";
}

sql.append( " where " ).append( whereCondition );
pst = con.prepareStatement( sql.toString() );