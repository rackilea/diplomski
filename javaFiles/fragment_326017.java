StringBuilder query = new StringBuilder();
query.append(" SELECT cdn, ");
query.append("       dn_gruppe, ");
query.append("       afsluttet_af AS INITIALS, ");
query.append("       agentgruppe  AS AGENTGROUP, ");
query.append("       status, ");
query.append("       created, ");
query.append("       last_upd, ");
query.append("       CASE ");
query.append("         WHEN Calculate_callback_duration(created, last_upd) IS NULL THEN ");
query.append("         Calculate_callback_duration(AA.this_date_opening, last_upd) ");
query.append("         ELSE Calculate_callback_duration(created, last_upd) ");
query.append("       END          AS SOLVED_SECONDS ");
query.append(" FROM   genesys.nyk_siebel_callback_agent_hist@ccon.nykreditnet.net ");
query.append("       left join ks_drift.sys_date_ks AA ");
query.append("              ON To_date(Trunc(last_upd), 'YYYY-MM-DD') = AA.this_date ");
query.append(" WHERE  tidspunkt > ( SYSDATE - 427 ) ");

ResultSet rs = db.executeQuery(query.toString());
while(rs.next()) {
  //check if the field have value or return null. It is needed when your field can return null values from the database
  Integer solvedSeconds = rs.getObject("SOLVED_SECONDS") != null ? rs.getInt("SOLVED_SECONDS") : null;

  System.out.println("Solved seconds: " + (solvedSeconds != null ? solvedSeconds.toString() : ""));

}