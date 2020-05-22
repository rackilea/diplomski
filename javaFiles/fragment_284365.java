String hex = "00000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000009796f6f6f6f6f6f6f6f0000000000000000000000000000000000000000000000";
StringBuilder output = new StringBuilder();
for (int i = 0; i < hex.length(); i+=2) {
    String str = hex.substring(i, i+2);
    output.append((char)Integer.parseInt(str, 16));
}
System.out.println(output.toString().trim());