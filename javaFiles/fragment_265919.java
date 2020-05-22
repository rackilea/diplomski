String s = "[WARNING] E:\\workspaces\\asd\r\n[WARNING] E:\\workspaces\\dsa\r\n\r\n[INFO] \r\n12 warnings\r\n[WARNING] Javadoc Warnings\r\n[WARNING] E:\\workspaces\\1\r\n[WARNING] E:\\workspaces\\2\r\n[WARNING] E:\\workspaces\\3\r\n\r\n[INFO] Building jar: E:\\workspaces\\asdf\r\n[INFO] \r\n[INFO] >>> maven-source-plugin:3.0.1:j\r\n\r\n[INFO] \r\n[INFO] <<< maven-source-plugin:3.0.1:j\r\n[INFO] \r\n12 warnings\r\n[WARNING] Javadoc Warnings\r\n[WARNING] E:\\workspaces\\4\r\n[WARNING] E:\\workspaces\\5\r\n[WARNING] E:\\workspaces\\6\r\n[INFO] Building jar: E:\\workspaces\\asdf\r\n[INFO] \r\n[INFO] >>> maven-source-plugin:3.0.1:j\r\n[INFO] \r\n[INFO] <<< maven-source-plugin:3.0.1:j";
Pattern pattern = Pattern.compile("(?:\\G(?!\\A)|\\[WARNING] Javadoc Warnings)\\R(\\[WARNING].*)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}