public static void main(String[] args) {
    String myOriginalString = "   fname lname, GTA V: 120 : 00000, Minecraft : 20 : 10, Assassin’s Creed IV : 90 : 800, Payday 2 : 190 : 2001 ,Wolfenstein TNO : 25 : 80, FarCry 4 : 55 : 862";
    // | is the regex OR operator
    String[] splited = myOriginalString.split(",|:");
    for(String s : splited)
    System.out.println(s.trim());
}