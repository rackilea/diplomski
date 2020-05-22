String qr = "PREFIX : <http://www.example.com/tempsensor#>\n" +
            "PREFIX  xsd: <http://www.w3.org/2001/XMLSchema#> \n"+
            "SELECT \n"+
            "?Place ?Temperature (STR(?Date) AS ?StrDate) \n"+ 
            "WHERE\n"+
            "{ ?ind :locatedIn ?Place .\n " +
            "  ?ind :measures ?Temperature .\n " +
            "  ?ind :onDate ?Date .\n " +
            "  FILTER(regex(str(?Place),'Delhi', 'i'))\n"+
            "  FILTER ( datatype(?Date) = xsd:dateTime)\n"+
            "}";