strtotime.registerMatcher(new Matcher() {

    private final Pattern days = Pattern.compile("[\\-\\+]?\\d+ days");

    public Date tryConvert(String input) {

        if (days.matcher(input).matches()) {
            int d = Integer.parseInt(input.split(" ")[0]);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, d);
            return calendar.getTime();
        }

        return null;
    }
});