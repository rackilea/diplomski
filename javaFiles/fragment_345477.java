String sql =
        "INSERT INTO Schedule " +
        "(MatchNumber, FirstTeam, SecondTeam, FirstTeamScore, SecondTeamScore, MatchDate) " +
        "VALUES " +
        "(?,?,?,?,?,?)"
PreparedStatement ps = c1.prepareStatement(sql)
ps.setInt(1, m);
ps.setString(2, ft);
ps.setString(3, st);
ps.setInt(4, s1);
ps.setInt(5, s2);
ps.setDate(6, d);
int z = ps.executeUpdate();