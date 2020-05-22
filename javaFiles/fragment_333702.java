public void createAllTable(Connection conn, Statement st)
{
    conn.setAutoCommit(false);
    this.createPlayerTable(conn, st);
    this.createClubTable(conn, st);
    this.createGameTable(conn, st);
    this.createMatchTable(conn, st);
    conn.commit( );
}