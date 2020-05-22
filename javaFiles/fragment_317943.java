String reg="(\\w+)\\s*=\\s*((?>\\{[^\\{\\}]*\\})|(?>.*$))";
Pattern pMod = Pattern.compile(reg, Pattern.MULTILINE);
Matcher mMod = pMod.matcher(line);
while (mMod.find()) {
    System.out.println(mMod.group(1));
    System.out.println(mMod.group(2));
}