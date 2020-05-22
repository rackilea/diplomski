abc="PREFIX table: <http://www.daml.org/2003/01/periodictable/PeriodicTable#>\n" +
        "SELECT ?name\n" +
        "FROM <http://www.daml.org/2003/01/periodictable/PeriodicTable.owl>\n" +
        "WHERE {\n" +
        "      ?element table:name ?name.\n" +
        "      FILTER(str(?name)=\"sodium\")\n" +
        "      }"