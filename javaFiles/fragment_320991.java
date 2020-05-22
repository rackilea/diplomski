Pattern p = Pattern.compile("\\d+_(\\w+)\\.txt");
    Matcher m = p.matcher("33232_abcTextFile.txt");
    if (m.matches()) {
        if (m.group(1).equals("abFile")) {
            // Do something
        } else if (m.group(1).equals("abcTextFile")) {
            // Do something else
        } else {
            // Unknown filename, handle it
        }
    } else {
        // Unknown file format, handle it
    }