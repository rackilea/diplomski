public static Map<String, String> getPreviousQuarter(String start,
        String end) {
    String prevStartQuarter = calulatePreviousQuarter(start);
    String prevEndQuarter = calulatePreviousQuarter(end);
    int len=1;
    while(!start.equals(prevEndQuarter)){
        prevEndQuarter=calulatePreviousQuarter(prevEndQuarter);
        len++;
    }
    String tmp=prevStartQuarter;
    for(int i=0;i<len;i++){
        tmp=calulatePreviousQuarter(tmp);
    }
    Map<String, String> returnMap = new HashMap<String, String>();
    returnMap.put("previousStartQuarter", prevStartQuarter);
    returnMap.put("previousEndQuarter", tmp);
    System.out.println("the reurnmap is" + returnMap);
    return returnMap;

}

private static String calulatePreviousQuarter(String input) {
    int yearVal = 0;

    String year = input.substring(0, 4);
    String quarter = input.substring(4);
    if (quarter.equalsIgnoreCase("01")) {
        yearVal = Integer.valueOf(year) - 1;
        quarter = "04";
    } else {
        yearVal = Integer.valueOf(year);
        switch (quarter) {
        case "02":
            quarter = "01";
            break;
        case "03":
            quarter = "02";
            break;
        case "04":
            quarter = "03";
            break;
        default:
            break;

        }
    }

    return String.valueOf(yearVal) + quarter;
}