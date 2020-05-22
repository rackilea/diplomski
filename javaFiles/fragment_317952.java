String s = "file:///C:/Users/nikhil.karkare/dev/pentaho/data/"
    + "ba-repo-content-original/public/Development+Activity/"
    + "Defects+Unresolved+%252528by+Non-Developer%252529.xanalyzer";

// %253528 ... %252529
s = URLDecoder.decode(s, "UTF-8");
// %2528 ... %2529
s = URLDecoder.decode(s, "UTF-8");
// %28 .. %29
s = URLDecoder.decode(s, "UTF-8");
// ( ... )