String[] ss = { "100", "10", "KONG", "102.65" };
    List<String> s = Arrays.asList(ss);
    Collections.sort(s, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            if (isNumber(o1)) {
                if (isNumber(o2)) {
                    // o1 = number
                    // o2 = number
                    return (Double.valueOf(o1).compareTo(Double.valueOf(o2)));
                } else {
                    // o1 = number
                    // o2 = string
                    return -1;
                }
            } else {
                if (isNumber(o2)) {
                    // o1 = string
                    // o2 = number
                    return 1;
                } else {
                    // o1 = string
                    // o2 = string
                    return o1.compareTo(o2);
                }
            }
        }

        private boolean isNumber(String s) {
            try {
                Double.parseDouble(s);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

    });
    System.out.println(s);
}