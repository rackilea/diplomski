int minHour = 6;
    int maxHour = 17;
    if (! data.isEmpty()) {
        // adjust min and max from list contents
        int minExisintgHour = data.get(0).getLocalTime().getHour();
        if (minExisintgHour < minHour) {
            // if the list already contained 4:00 or 4:30,
            // we only need to add hours from 5, so add 1
            minHour = minExisintgHour + 1;
        }
        int maxExisintgHour = data.get(data.size() - 1).getLocalTime().getHour();
        if (maxExisintgHour > maxHour) {
            maxHour = maxExisintgHour;
        }
    }
    for (int hour = minHour; hour <= maxHour; hour++) {
        LocalTime time = LocalTime.of(hour, 0);
        boolean alreadyInData = data.stream().anyMatch(d -> d.getLocalTime().equals(time));
        if (! alreadyInData) {
            data.add(new DataClass(time, "Added beacuse time was missing"));
        }
    }