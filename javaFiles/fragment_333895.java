Pattern p = Pattern.compile("^(CS [0-9][0-9][0-9][0-9]).*");
    Pattern p2 = Pattern.compile("^Prereq");
    Pattern p3 = Pattern.compile("[A-Z]+ [0-9]{4}");
    while ((line = br.readLine()) != null) {
        Matcher m = p.matcher(line);
        if (m.find()) {
            System.out.println(m.group(1));
        }
        Matcher m2 = p2.matcher(line);
        if (m2.find()){
            final Matcher m3 = p3.matcher(line);
            while (m3.find()) {
                System.out.println("Prereq: " + m3.group(0));
            }
        }
    }