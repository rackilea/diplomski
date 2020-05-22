public String getTableNameFromCreate(final String sqlString) {
    // Always rememeber...we're only trying to get the table 
    // name from the SQL String. We really don't care anything
    // about the rest of the SQL string.
    String tableName;
    String wrkStrg = sqlString.replace("[", "").replace("]", "").trim();
    // Is "CREATE TABLE" only
    if (wrkStrg.startsWith("CREATE TABLE ")) {
        wrkStrg = wrkStrg .substring(13).trim();
    }
    else if (wrkStrg.startsWith("CREATE GLOBAL TEMPORARY TABLE ")) {
        wrkStrg = wrkStrg .substring(30).trim();
    }
    else if (wrkStrg.startsWith("CREATE TEMPORARY TABLESPACE ")) {  
        wrkStrg = wrkStrg .substring(28).trim();
    }

    // Is it Create Table ... AS, AS SELECT, PARALLEL COMPRESS AS, 
    // or PARALLEL COMPRESS AS SELECT?
    if (wrkStrg.toUpperCase().contains(" PARALLEL COMPRESS ")) {
        wrkStrg = wrkStrg.replace(" parallel compress ", " PARALLEL COMPRESS ");
        tableName = wrkStrg.substring(0, wrkStrg.indexOf(" PARALLEL COMPRESS ")).trim();
    }
    else if (wrkStrg.toUpperCase().contains(" AS ")) {
        wrkStrg = wrkStrg.replace(" as ", " AS ");
        tableName = wrkStrg.substring(0, wrkStrg.indexOf(" AS ")).trim();
    }
    // Nope...none of that in the SQL String.
    else {
        tableName = wrkStrg.substring(0, wrkStrg.indexOf("(")).trim();
    }

    // return but remove quotes first if any...
    return tableName.replace("\"","").replace("'", "");
}