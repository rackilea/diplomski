String str = "32.63578";
int i = str.indexOf(".") + 3;
String part1 = str.substring(0, i);     // "32.63"
String part2 = str.substring(i);        // "578"

float num1 = Float.parseFloat(part1);   // 32.63
long num2 = Long.parseLong(part2);      // 578