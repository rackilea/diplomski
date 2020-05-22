String filePattern = "KB_H9Oct4GFP_20130305_p00{iiii}t00000{ttt}z001c02.tif";
int startTimeSlice = 1;
int startTile = 1;

Pattern patternTime = Pattern.compile("(\\{[t]*\\})");
Matcher matcherTime = patternTime.matcher(filePattern);

if (matcherTime.find()) {
    String timePattern = matcherTime.group(0);// {ttt}

    NumberFormat timingFormat = new DecimalFormat(timePattern.replaceAll("t", "0")
            .substring(1, timePattern.length() - 1));// 000

    Pattern patternPosition = Pattern.compile("(\\{[i]*\\})");
    Matcher matcherPosition = patternPosition.matcher(filePattern);

    if (matcherPosition.find()) {
        String positionPattern = matcherPosition.group(0);// {iiii}

        NumberFormat positionFormat = new DecimalFormat(positionPattern
                .replaceAll("i", "0").substring(1, positionPattern.length() - 1));// 0000

        System.out.println(filePattern.replace(timePattern,
                timingFormat.format(startTimeSlice)).replace(positionPattern,
                positionFormat.format(startTile)));
    }
}