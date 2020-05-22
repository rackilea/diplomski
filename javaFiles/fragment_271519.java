public String[] getTimesFromDocumentHistoryReportPage() {
        String htmlSource = driver.getPageSource();
        final Pattern pattern = Pattern.compile("<td align=\"CENTER\">(.+?)</td>");
        final String[] tagValues = new String[2];
        final Matcher matcher = pattern.matcher(htmlSource);

        for (int i = 0; i < 2; i++) {
            matcher.find();
            tagValues[i] = matcher.group(1);
        }
        return tagValues;
    }