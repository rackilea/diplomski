String tring = "CHARDATA_FRMT: <<<$gen>>>(((valu e)))    <<<$gen>>>(((value 13231)))\n<<<$gen>>>(((value 13231)))";
Pattern p = Pattern.compile("<{3}\\$([\\w ]+)>{3}\\s?\\({3}([\\w ]+)\\){3}");
Matcher m = p.matcher(tring);
while (m.find()){
    System.out.println("Gen: " + m.group(1) + ", and value: " + m.group(2));
}