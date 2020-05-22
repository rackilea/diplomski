public static boolean compareCardExpDateLexicographically(String dateToCompare) {
    SimpleDateFormat sdf = new SimpleDateFormat("yy/MM", Locale.US);
    Date date = new Date();
    String currentDate = sdf.format(date);
    String dateToComp = sdf.format((parseCardExpiryDate(dateToCompare)).getTime());

    Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {

            if (o1.compareTo(o2) == 9) return -1;
            else if (o1.compareTo(o2) == -9) return 1;
            else if (o1.compareTo(o2) > 0) return 1;
            else if (o1.compareTo(o2) == 0) return 0;
            else return -1;
        }
    };

    return comp.compare(dateToComp, currentDate) >= 0;
}