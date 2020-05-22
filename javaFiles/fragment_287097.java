public static void main(String[] args) {
        String s = "21:45.9 INFO    SSHD    SSHD-TRANSFER-1 [accountName=root] [remoteAddress=/172.16.8.1:64931]:Invoking logout agent [accountName=null remoteAddress=STEDGE/172.16.8.3]   AuthenticationProviderImpl.java com.tumbleweed.st.server.sshd.AuthenticationProviderImpl    executeLogoutAgent  425 UNKNOWN UNKNOWN UNKNOWN UNKNOWN UNKNOWN UNKNOWN UNKNOWN UNKNOWN\r\n";
        Pattern pattern = Pattern.compile("(?<=remoteAddress=/)[\\d.]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }

    }