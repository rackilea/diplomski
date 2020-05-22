Matcher m = Pattern.compile("(\\d+)-(\\d+)?\\s*(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)").matcher(input);
while (m.find()) {
    if (m.groupCount()==3) {
        int first = Integer.valueOf(m.group(1));
        int second = Integer.valueOf(m.group(2));
        String month = m.group(3);
        // DO something here
    } else {
        int first = Integer.valueOf(m.group(1));
        String month = m.group(2);
        // Do something here
    }
}