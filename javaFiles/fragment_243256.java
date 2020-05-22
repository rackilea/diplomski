String ghost = "ghost";
String input = "o";
for (int i = 0; i < ghost.length(); i++) {
    if (String.valueOf(ghost.charAt(i)).equalsIgnoreCase(input)) {
        System.out.print(input + " ");
    } else {
        System.out.print("_ ");
    }
}