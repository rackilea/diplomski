String input = "({Temp_in_degrees} / {Speed}) * 30;";
    Pattern pattern = Pattern.compile("\\{\\S+\\}");

    Scanner scanner = new Scanner(input);
    String output;
    while ((output = scanner.findInLine(pattern)) != null) {
        System.out.println(output);
    }
    scanner.close();