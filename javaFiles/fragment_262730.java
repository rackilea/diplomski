static String format(List<Date> days) {
        if (days.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        DateFormat format = new SimpleDateFormat("MMM d");
        Collections.sort(days);
        String separator = "";
        for (Date day: days) {
            sb.append(separator);
            sb.append(format.format(day));
            separator = ", ";
        }
        sb.append(" ");
        return sb.toString();
    }