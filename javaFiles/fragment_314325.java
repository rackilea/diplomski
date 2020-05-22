@Test
public void expressionTest() {
    Date date;
    CronExpression exp;
    // Run every 10 minutes and 30 seconds in the year 2002
    String a = "30 */10 * * * ? 2002";      
    // Run every 10 minutes and 30 seconds of any year
    String b = "30 */10 * * * ? *"; 
    try {
        exp = new CronExpression(a);
        date = exp.getNextValidTimeAfter(new Date());
        System.out.println(date);       // null
        exp = new CronExpression(b);
        date = exp.getNextValidTimeAfter(new Date());
        System.out.println(date);       // Tue Nov 04 19:20:30 PST 2014
    } catch (ParseException e) {
        e.printStackTrace();
    }
}