try { conn = poolDataSouorce.getConnection ... } catch (SQLException sqlexc)
{
    if (conn == null || !((ValidConnection) conn).isValid())        
        // take the appropriate action   
    conn.close
}