ArrayList<String> dirNo = new ArrayList<String>();

    dirNo.add("1");
    dirNo.add("2");
    dirNo.add("3");
    dirNo.add("4");
    dirNo.add("5");
    dirNo.add("6");
    dirNo.add("7");
    dirNo.add("8");
    dirNo.add("9");
    dirNo.add("10");
    dirNo.add("11");

    Comparator<String> cmp = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
        }
    };
    System.out.println("max : " + Collections.max(dirNo, cmp));