String s = "1.) \"b.jpg\" from \"192.168.1.101:40000\"";
        Pattern p = Pattern.compile("^[0-9]+\\.\\).*$"); // works also if you use * instead of +
        if (p.matcher(s).matches()) {
            System.out.println("match");
        }
        else {
            System.out.println("No Match!");
        }