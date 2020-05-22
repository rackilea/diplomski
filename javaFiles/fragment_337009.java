Property File :-
Query1 = SELECT * FROM apmokejimai LEFT JOIN irasai ON apmokejimai.apm_invoice_nr = irasai.invoice_nr WHERE (FIND_IN_SET(?, irasai.pirkejas) OR FIND_IN_SET(?, irasai.pirkejas) IS NULL) AND (FIND_IN_SET(id, irasai.pirk_vad) OR FIND_IN_SET(id,irasai.pard_vad)) order by apmokejimai.apm_invoice_nr
Query2= SELECT * FROM apmokejimai LEFT JOIN irasai ON apmokejimai.apm_invoice_nr = irasai.invoice_nr WHERE (FIND_IN_SET(?, irasai.pirkejas) OR FIND_IN_SET(?, irasai.pirkejas) IS NULL) order by apmokejimai.apm_invoice_nr

String sql = "";
if (klases.type == 0) {                
    sql = "Get the Query1 from Property File";
    ps = conn.prepareStatement(sql);
    ps.setInt(1, pirk);
    ps.setInt(2, pirk);
    ps.setString(3, sql2);
}else{
    sql = "Get the Query2 from Property File";  
    ps = conn.prepareStatement(sql);
    ps.setInt(1, pirk);
    ps.setInt(2, pirk);
}