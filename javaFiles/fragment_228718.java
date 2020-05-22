while ((sCurrentLine = br.readLine()) != null) {
    List<String> s = Arrays.asList(sCurrentLine.split("\\s+"));
    Collections.shuffle(s);
    for (String split : s) {
        if (split.matches("\\d*")) {
            System.out.println(split);
        }
    }
}