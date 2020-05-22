final DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
Collections.sort(newsList, new Comparator<Map<String, String>>() {
    @Override
    public int compare(Map<String, String> left, Map<String, String> right) {
        return dateFormat.parse(left.get("date")).compareTo(dateFormat.parse(right.get("date")));
    }
});