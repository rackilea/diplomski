public static void main(String[] args) {

    // %d [%t] %-7p %10c{1} - %m%n

    // ISO8601_date
    // space
    // [
    // thread_id
    // ]
    // space
    // priority
    // space
    // category (basename)
    // space
    // -
    // space
    // message
    // line.separator

    String[] samples = {
        "1999-11-27 15:49:37,459 [thread-x] ERROR mypackage - Catastrophic system failure"
    };

    String regex = "(\\d{4}-\\d{2}-\\d{2}) (\\d{2}:\\d{2}:\\d{2},\\d{3}) \\[(.*)\\] ([^ ]*) ([^ ]*) - (.*)$";

    Pattern p = Pattern.compile(regex);

    Matcher m = p.matcher(samples[0]);

    if (m.matches() && m.groupCount() == 6) {
        String date = m.group(1);
        String time = m.group(2);
        String threadId = m.group(3);
        String priority = m.group(4);
        String category = m.group(5);
        String message = m.group(6);

        System.out.println("date: " + date);
        System.out.println("time: " + time);
        System.out.println("threadId: " + threadId);
        System.out.println("priority: " + priority);
        System.out.println("category: " + category);
        System.out.println("message: " + message);
    }
}