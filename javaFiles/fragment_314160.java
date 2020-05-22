List<String> list = new ArrayList<>(Arrays.asList("12","10L","10","10R","10S","10L","14L","14","8","12S"));
List<String> orderArray = new ArrayList<>(Arrays.asList("S", "R", "L"));

list.sort(new Comparator<String>() {
        @Override
        public int compare(String lhs, String rhs) {
            int lInt = Integer.parseInt(lhs.replaceAll("[A-Z]*", ""));
            int rInt = Integer.parseInt(rhs.replaceAll("[A-Z]*", ""));
            if (lInt != rInt) {
               return lInt - rInt;
            } else {
                return getAnInt(orderArray, lhs) - getAnInt(orderArray, rhs);
            }
        }
    });

System.out.println(list);