Scanner in = new Scanner(System.in);
String line = in.nextLine();
Pattern p = Pattern.compile("[0-9]+([.]([0-9]+))?");
if(p.matcher(line).matches()){
    System.out.println("number");
} else {
    System.out.println("text");
}