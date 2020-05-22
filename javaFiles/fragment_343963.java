Date date;
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

    try {
        date = df.parse(String.valueOf(_time.getTime()));
    } catch (ParseException e) {
        throw new RuntimeException("Failed to parse date: ", e);
    }

    return date.getTime();