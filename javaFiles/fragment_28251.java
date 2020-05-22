private final static String XML_START_TAG = "<?xml>";
private final static String XML_END_TAG = "</xml>";

private static String doubleSqlQuote(String req) {
    if (req.contains(XML_START_TAG) && req.indexOf(XML_START_TAG) < req.lastIndexOf(XML_END_TAG)) {
        req = req.substring(0, req.indexOf(XML_START_TAG))
                + req.substring(req.indexOf(XML_START_TAG), req.lastIndexOf(XML_END_TAG)).replace("'", "''")
                + req.substring(req.lastIndexOf(XML_END_TAG));
    }
    return req;
}

public static void main(String[] args) {
    final String req = "insert into table (name,data) values ('test','<?xml><some><tag></tag></some><data>Here replace ' with ''</data></xml>')";
    System.out.println(doubleSqlQuote(req));
}