public class LogRegExp {

    public static void main(String argv[]) {
        String logEntryLine = "Apr 10 21:08:55 kali sshd[37727]: Failed password for root from 127.0.0.1 port 42035 ssh2";
        String logEntryPattern = "([\\w]+\\s[\\d]+\\s[\\d:]+)\\s([\\w]+)\\s([\\w]+)\\[.+\\]:\\s(.+)";

        Pattern p = Pattern.compile(logEntryPattern);
        Matcher matcher = p.matcher(logEntryLine);
        if (!matcher.matches()) {
            System.err.println("Bad log entry (or problem with RE?):");
            System.err.println(logEntryLine);
            return;
        }
        System.out.println("Date&Time: " + matcher.group(1));
        System.out.println("Hostname: " + matcher.group(2));
        System.out.println("Program Name: " + matcher.group(3));
        System.out.println("Log: " + matcher.group(4));

    }
}