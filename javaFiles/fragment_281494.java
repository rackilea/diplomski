String source = "{11-11,22},{33-33,44},{88-88,99}";
    String[] splittedSource = source.split("(?<=\\}),(?=\\{)");
    Pattern p = Pattern.compile("\\{([^,]+),([^\\}]+)");
    String[][] result = new String[splittedSource.length][2];
    for(int i = 0; i < splittedSource.length; i++) {
        Matcher m = p.matcher(splittedSource[i]);
        while(m.find()) {
            result[i][0] = m.group(1);
            result[i][1] = m.group(2);
            System.out.print(m.group(1) + " " + m.group(2) + "\n");
        }
    }
    System.out.println(Arrays.deepToString(result));