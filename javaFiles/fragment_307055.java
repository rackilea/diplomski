String test = "6-006.a9&&20130323^000~1-206&&20130329^000~1-208.2&&20130322^000";
//                           ┌ look behind for "&&"
//                           |      ┌ group 1: year
//                           |      |       ┌ group 2: month
//                           |      |       |       ┌ group 3: day
//                           |      |       |       |       ┌ look ahead 
//                           |      |       |       |       | for escaped "^"
Pattern p = Pattern.compile("(?<=&&)(\\d{4})(\\d{2})(\\d{2})(?=\\^)");
// initialize matcher
Matcher m = p.matcher(test);
// iterate matches
while (m.find()) {
    // print matches formatted for each group
    System.out.printf(
        "Found: year %s / month %s / day %s%n", 
        m.group(1), 
        m.group(2), 
        m.group(3)
    );
}