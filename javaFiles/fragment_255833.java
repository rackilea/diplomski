if (total > reccomended_max){
    String message = "The total staff wages for " + ...;
    try (PrintStream out = new PrintStream(new FileOutputStream("output.txt", true))) {
        out.println(message);
    } // here, the stream will be automatically flushed and closed!

    System.out.println(message);
} else {
    System.out.println("The total staff wages for " + Unitnum + " is £" +total + ", therefore it is lower than the RM");
}