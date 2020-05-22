Scanner sc = new Scanner(System.in);
System.out.println("Type .png input (base64): ");
StringBuilder sb = new StringBuilder();
while (sc.hasNext())
    sb.append(sc.next());
String data = sb.toString();