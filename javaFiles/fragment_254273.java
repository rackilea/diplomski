public static void main(String [] args) {
    String[] vals = {"grant     insert,update,delete on ABC.TABLE_NAME to group DACT_RW, group DACT_RW_BATCH1"};
    String eodAppendedDbObjectName = "ABC.TABLE_NAME";
    Pattern p = Pattern.compile("[gG][rR][aA][nN][tT]\\s+[iI][nN][sS][eE][rR][tT]\\s*,\\s*[uU][pP][dD][aA][tT][eE]\\s*,\\s*[dD][eE][lL][eE][tT][eE]\\s+[oO][nN]\\s+" + eodAppendedDbObjectName + "\\s+[tT][oO]\\s+[gG][rR][oO][uU][pP]\\s+DACT_RW\\s*,\\s*[gG][rR][oO][uU][pP]\\s+DACT_RW_BATCH1$");        
    for (String s : vals) {
        Matcher m = p.matcher(s);
        if (m.matches()) {
            System.out.println(s + " matches.");
        } else {
            System.out.println(s + " does not match.");
        }
    }
}