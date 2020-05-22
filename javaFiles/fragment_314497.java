public String calculate(String[] a) {

    StringBuilder output = new StringBuilder();

    for (String s : a) {
        output.append(' ').append(s);
    }
    return output.toString();
}