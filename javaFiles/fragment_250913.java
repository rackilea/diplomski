try {
    date = sdf1.parse(dt);
} catch (ParseException e) {
    try {
        date = sdf2.parse(dt);
    } catch (ParseException e1) {
        try {
            date = sdf3.parse(dt);
        } catch (ParseException e2) {
            // TODO: Whatever to do when it doesn't find a date
        }
    }
}