String[] timeStrings = { "03:45", "1:03:45", "123:03:45" };
    for (String timeString : timeStrings) {
        String modifiedString = timeString.replaceFirst("^(\\d+):(\\d{2}):(\\d{2})$", "PT$1H$2M$3S")
                .replaceFirst("^(\\d+):(\\d{2})$", "PT$1M$2S");
        System.out.println("Duration: " + Duration.parse(modifiedString));
    }