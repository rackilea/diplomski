public static void main(String[] args) { 
    String evilString = null;
    System.out.println(new StringBuilder()
        .append(
                evilString.toLowerCase()));  // <--- NPE here (line 9)
}