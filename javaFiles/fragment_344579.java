System.out.print("Input:");
Reader r = new new InputStreamReader(System.in);
int val = r.read() - '0';
System.out.print("Output:");
if (val < 0 || val > 9) {
  System.out.println("error, digit expected");
} else {
  System.out.println(val);
}