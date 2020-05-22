Scanner in = new Scanner(System.in);
System.out.println("Enter String pls:");
String str = in.nextLine();
StringBuilder output = new StringBuilder();
for (char c : str.toCharArray()){
    if ("aeiou".contains(""+c)){
        output.append((char)(c+1));
    } else {
        output.append(""+c);
    }
}
System.out.println(output.toString());