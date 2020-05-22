LinkedList<Integer> numbers = new LinkedList<Integer>();

    Pattern p = Pattern.compile("\\d+");


    String line = "9/8*9+3";
    Matcher m = p.matcher(line);
    numbers.clear();
    while (m.find()) {
        numbers.add(Integer.parseInt(m.group()));
    }