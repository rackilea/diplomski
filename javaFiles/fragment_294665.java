nameToAcctQuery="SELECT DISTINCT a.Acnum"
                + "FROM table c, table p, table a "
                + "WHERE c.First= ? "
                + "AND c.Mid= ? "
                + "AND c.Last= ? "
                + "AND p.Pol= a.pol"
                + "AND p.name= c.name";