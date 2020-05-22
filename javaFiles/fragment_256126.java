// To consider special characters as literals
String str = Pattern.quote("group.php?id=") + "(\\d*)";

Pattern script1 = Pattern.compile(str);
// Your matcher line
while (mscript1.find()) {
    content += mscript1.group(1) + "\n";   // Capture group 1 contains your id
}