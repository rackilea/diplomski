String message = "hello java";
String open = "<";
String close = ">";
String dash = "-";
int length = message.length();
int total = 0;

String str = "E-" + (length < 10 ? "0" : "") + length + "-" + message + "-";
for (int i = 0; i < str.length(); i++) {
    int mod = str.charAt(i);
    total += mod;
}
String output = open + str + total + close;
System.out.println(output);