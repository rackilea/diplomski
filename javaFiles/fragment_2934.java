private boolean isProperties(Scanner sc) {
    Pattern p = Pattern.compile("\\w.*[=:] *.+");
    int nProps = 0;
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        if (!line.startsWith("#")) {
            if (!p.matcher(line).matches()) {
                sc.close();
                return false;
            }
            nProps++;
        }
    }
    sc.close();
    return nProps > 0;
}

public boolean isProperties(String s) {
    return isProperties(new Scanner(s));
}

public boolean isProperties(File f) throws FileNotFoundException {
    return isProperties(new Scanner(f));
}

     ... more overloaded isProperties for different sources