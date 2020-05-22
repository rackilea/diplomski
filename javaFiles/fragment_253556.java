public string StripCommas(string str, int allowableCommas) {
    int comma;
    int found = 0;
    comma = str.indexOf(",");
    while (comma >= 0) {
        found++;
        if (found == allowableCommas) {
            return str.substring(0, comma) + str.substring(comma + 1).replaceAll(",", "");            
        }
        comma = str.indexOf(",", comma + 1);
    }
    return str;
}