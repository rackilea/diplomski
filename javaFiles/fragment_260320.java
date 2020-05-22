Pattern p = Pattern.compile("\"\\w+\\.jpg\",\\s(.*)");
    Matcher m = p.matcher("\"0f23af5c71e3f9d7f59ab14277e2023.jpg\", 10.0, 45.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 3.0, 3.0, 0.0, 0.0, 1.0, 3.0, 1.0, 5.0, 0.0");

    if(m.matches()) {
        System.out.println(m.group(1));
    }