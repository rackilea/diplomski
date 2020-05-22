Arrays.sort(array, new Comparator<String>() {

    Pattern p = Pattern.compile("^.*?-([A-Za-z]+)(\\d+)$");

    @Override
    public int compare(String o1, String o2) {
        Matcher m1 = p.matcher(o1);
        Matcher m2 = p.matcher(o2);

        if(!(m1.find() && m2.find()))
            return 0; // Or throw a format exception

        int comparison = m1.group(1).compareTo(m2.group(1));
        return comparison != 0
            ? comparison 
            : Integer.compare(Integer.parseInt(m1.group(2)), Integer.parseInt(m2.group(2)));
    }

});