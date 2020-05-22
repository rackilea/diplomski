public class Main {

    static String s = "[1463895327]PING www.gov.bw (168.167.134.24) 100(128) bytes of data.\n" +
            "[1463895327]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=1 ttl=110 time=868 ms\n" +
            "[1463895328]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=2 ttl=110 time=892 ms\n" +
            "[1463895329]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=3 ttl=110 time=814 ms\n" +
            "[1463895330]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=4 ttl=110 time=1009 ms\n" +
            "[1463895331]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=5 ttl=110 time=1006 ms\n" +
            "[1463895332]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=6 ttl=110 time=984 ms\n" +
            "[1463895333]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=7 ttl=110 time=1004 ms\n" +
            "[1463895334]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=8 ttl=110 time=1006 ms\n" +
            "[1463895335]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=9 ttl=110 time=1013 ms\n" +
            "[1463895336]108 bytes from www.gov.bw (168.167.134.24): icmp_seq=10 ttl=110 time=578 ms\n" +
            "[1463895336]\n" +
            "[1463895336]--- www.gov.bw ping statistics ---\n" +
            "[1463895336]10 packets transmitted, 10 received, 0% packet loss, time 9007ms\n" +
            "[1463895336]rtt min/avg/max/mdev = 578.263/917.875/1013.707/132.095 ms, pipe 2";

    public static void main(String args[]) throws IOException {
        System.out.print(Arrays.toString(parsePingStatisticsMinAvgMaxMdev(s)));
    }

    public static String[] parsePingStatisticsMinAvgMaxMdev(String input) { throws TimeNotFoundException {
        // Capture the rtt min/avg/max/mdev times
        Pattern p = Pattern p = Pattern.compile("rtt\\s+min\\/avg\\/max\\/mdev\\s+=\\s+(\\d+\\.\\d+)\\/(\\d+\\.\\d+)\\/(\\d+\\.\\d+)\\/(\\d+\\.\\d+)\\s+ms");
        Matcher m = p.matcher(input);
        if (m.find()) {
            int i = 1;
            String[] s = new String[4];
            while (m.find(i) && i <= 4) {
                s[i - 1] = m.group(i);
                i++;
            }
            return s;
        } else
            throw new TimeNotFoundException();
    }
}