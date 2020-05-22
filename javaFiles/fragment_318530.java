String s = "ClOuD ComPuTinG";
if(s.matches("(?i)cloud.*computing")) {
    System.out.println("MATCH"); // will print MATCH
} else {
    System.out.println("NOT");
}

if(s.matches("cloud.*computing")) {
    System.out.println("MATCH");
} else {
    System.out.println("NOT"); // will print NOT
}