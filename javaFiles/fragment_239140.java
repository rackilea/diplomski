String[] strs = {
                "START_TIME: 1400 HOURS     FINISH_TIME: 1000 HOURS",
                "START-TIME: 1400 HOURS     FINISH-TIME: 1100 HOURS",
                "-STARTTIME:  1400    FINISHTIME:  1100"};

String regex = "-?START([^:]+):([0-9 ]+)(HOURS)?\\s*FINISH(\\1):([0-9 ]+)(HOURS)?";
Pattern p = Pattern.compile(regex);
for (String str : strs) {
    Matcher m = p.matcher(str);
    if (m.find()) {
        String start = m.group(2).trim();
        String finish = m.group(5).trim();
        System.out.println("START:" + start + " FINISH:" + finish);
    }
}