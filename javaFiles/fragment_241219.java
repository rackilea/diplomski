public static void main(String args[]) throws Exception {

    String line = "WITH dataTab0 AS (SELECT TO_CHAR(to_date(tab_0_0.times),'YYYYMMDD')  AS TIME_ID_CATEGORYe93bc60a0041,tab_0_0.request_id AS PAGE_IMPRESSIONf6beefc154b44e4b  FROM full_contents_2";
    Pattern p = Pattern.compile("(TIME_ID_CATEGORY|PAGE_IMPRESSION)(\\w+)");
    Matcher m = p.matcher(line);
    if (m.find()) {
        String output = m.replaceAll("$1");
        System.out.println(output);
        //WITH dataTab0 AS (SELECT TO_CHAR(to_date(tab_0_0.times),'YYYYMMDD')  AS TIME_ID_CATEGORY,tab_0_0.request_id AS PAGE_IMPRESSION  FROM full_contents_2

    }

}