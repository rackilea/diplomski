/**
 * I need to override the getLimitString so that i can append the partition
 * by column on the end. If partition is not found in the string then it
 * will not be added.
 */
@Override
public String getLimitString(String sql, boolean hasOffset) {
    // LOG.info("Using our getLimitString value");
    sql = sql.trim();
    String forUpdateClause = null;
    boolean isForUpdate = false;
    final int forUpdateIndex = sql.toLowerCase().lastIndexOf( "for update") ;
    if ( forUpdateIndex > -1 ) {
        // save 'for update ...' and then remove it
        forUpdateClause = sql.substring( forUpdateIndex );
        sql = sql.substring( 0, forUpdateIndex-1 );
        isForUpdate = true;
    }
    String rank = "";
    if (sql.contains("partition")) {
        rank = findRank(sql);

    }
    StringBuilder pagingSelect = new StringBuilder( sql.length() + 100 );
    if (hasOffset) {
        pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
    }
    else {
        pagingSelect.append("select * from ( ");
    }
    pagingSelect.append(sql);
    if (hasOffset) {
        pagingSelect.append(" ) row_ where rownum <= ? ");
        pagingSelect.append(rank);
        pagingSelect.append(") where rownum_ > ?");
    }
    else {
        pagingSelect.append(" ) where rownum <= ?");
        pagingSelect.append(rank);
    }

    if ( isForUpdate ) {
        pagingSelect.append( " " );
        pagingSelect.append( forUpdateClause );
    }

    return pagingSelect.toString();
}

/**
 * Take our sql query find the partition line and pull off the hibernate
 * generated alias name.
 * 
 * @param sql
 * @return String - sql with rank limit
 */
private String addRank(String sql) {
    int partition = sql.indexOf("partition");
    String rank = "";
    if (partition != -1) {
        int start = partition;
        int end = sql.indexOf(',', start);
        String aliasName = end == -1 ? sql.substring(start) : sql
                .substring(start, end);
        int last = aliasName.indexOf("as");
        if (last != -1) {
           rank = " AND "+aliasName.substring(last + 2)+ " = 1";
        }
    }
    return rank;
}