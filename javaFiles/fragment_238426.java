Collections.sort(names, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            Pattern digits = Pattern.compile("\\d+");
            Matcher m1 = digits.matcher(o1);
            Matcher m2 = digits.matcher(o2);
            int i1 = 0;
            int i2 = 0;
            while (i1 < o1.length() && i2 < o2.length()) {
                boolean b1 = m1.find();
                int j1 = b1 ? m1.start() : o1.length();
                boolean b2 = m2.find();
                int j2 = b2 ? m2.start() : o2.length();
                String part1 = o1.substring(i1, j1);
                String part2 = o2.substring(i2, j2);
                int cmp = String.compareIgnoreCase(part1, part2);
                if (cmp != 0) {
                    return;
                }
                if (b1 && b2) {
                    int num1 = Integer.parseInt(m1.group());
                    int num2 = Integer.parseInt(m2.group());
                    cmp = Integer.compare(num1, num2);
                    i1 = m1.end();
                    i2 = m2.end();
                } else if (b1) {
                    return -1;
                } else if (b2) {
                    return 1;
                }
            }
            return 0;
        }
    });