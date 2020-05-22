// fyi, the regex of this split trims automatically
String[] fields = tmp.replace("\""," ").replace("\'","\'\'").trim().split("\\s*\\|\\s*");
// Do any special field processing (most need none)
field[0] = getiCtr(parseMSISDN(field[5])); // for example - just do what you need
// Now set all the SQL params
int col = 0;
for (String field : fields) {
    stmt.setString(++col, field); // Note: SQL API is 1-based (not zero-based)
}