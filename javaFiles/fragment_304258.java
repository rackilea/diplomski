while ((line = br.readLine()) != null) {
    Matcher pinNameMatcher = PinNamePattern.matcher(line);
    if (pinNameMatcher.find()) {
        currentApperture = pinNameMatcher.group(0);
        System.out.println(currentApperture);
    }

    Matcher locXYMatcher = LocationXYPattern.matcher(line);
    if (locXYMatcher.find()) {
        System.out.println(locXYMatcher.group(0));
    }

    Matcher locXYIJMatcher = LocationXYIJPattern.matcher(line);
    if (locXYMatcher.find()) {
        System.out.println(locXYIJMatcher.group(0));
    }
}