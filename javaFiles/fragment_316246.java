public static final String URL_REGEX = "^((https?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$";

Pattern p = Pattern.compile(URL_REGEX);
Matcher m = p.matcher("example.com");//replace with string to compare
if(m.find()) {
    System.out.println("String contains URL");
}