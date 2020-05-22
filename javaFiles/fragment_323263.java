public static void main(String[] args) throws Exception {
    Pattern p = Pattern.compile("^(\\w*)[\\s]+(\\w*)[\\s]+(\\w*)[\\s]+(\\w*)[\\s]+(\\w*)[\\s]+[“](.*)[”][\\s]+[“](.*)[”][\\s]+[“](.*)[”]");
    Matcher m = p.matcher("AddItem rt456 4  12 BOOK “File Structures” “Addison-Wesley” “Michael Folk”");

    if (m.find()) {
        for (int i=1;i<=m.groupCount();i++) {
            System.out.println(m.group(i));
        }
    }
}