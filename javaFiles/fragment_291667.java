List<String> list = new ArrayList<>();
    File file = new File("logfile");
    BufferedReader br = new BufferedReader(new FileReader(file));
    Pattern e = Pattern.compile(".*\\[ERROR\\] [A-Za-z]+ ([A-Za-z0-9]+)");
    String st;
    while ((st = br.readLine()) != null) {
        Matcher m = e.matcher(st);
        if (m.find()) {
            list.add(m.group(1));

        }
    }
    for (String aList : list) {
        System.out.println(aList);
    }