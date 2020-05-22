String input = "'أَبَنَ فُلانًا: عَابَه ورَمَاه بخَلَّة سَوء.'";
Pattern p = Pattern.compile("[\\p{P}\\p[Mn]");
Matcher m = p.matcher(input);
while (m.find()) {
    System.out.println("found: " + m.group());
}
m.reset();
System.out.println("Replaced: " + m.replaceAll(" "));