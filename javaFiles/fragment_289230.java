String sql1 = "INSERT INTO transferred (subjectCode,subjectName,credit,prequisite,matricsNo) "
                    + "SELECT b.subjectCode,b.subjectName,b.credit,b.prequisite,s.matricsNo "
                    + "FROM bitm b, student s "
                    + "WHERE b.subjectCode = ?  AND b.subjectName = ? AND s.matricsNo = ? ";


            ps = con.prepareStatement(sql1);

            ps.setString(1, sbjC);
            ps.setString(2, sbjN);
            ps.setString(3,matricsno);

ps.executeUpdate ();