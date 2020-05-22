if (country.equals("Australia")) {
    in.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
    SimpleDateFormat out = new SimpleDateFormat("hh:mm");
    out.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
    return out.format(in.parse(time));
}