String strInsert = "INSERT INTO this_table (loc_nbr, rpt_nbr, rpt_type,  rpt_seq, alcohol, drugs, cyber, priority,office_code,date_submitted) VALUES (?, ?, ?, ?, ?, ?, ?, ?,'HOME', sysdate,);";

CallableStatement cs = Connection.prepareCall(strInsert);
cs.setString(1, "'" + strLocationNumber + "'");
cs.setString(2, "'" + strReportNumber + "'");
cs.setString(3, "'" + strReportType + "'");
cs.setString(4, "'" + strReportSeq + "'");
cs.setString(5, "'" + strAlcohol + "'");
cs.setString(6, "'" + strDrugs + "'");
cs.setString(7, "'" + strCyber + "'");
cs.setString(8, "'" + strPriority + "'");
cs.execute();