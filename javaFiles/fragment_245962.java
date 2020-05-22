List<String> myList = Arrays.asList("172.16.8.3",
            "Invoking logout agent [accountName=rene1 remoteAddress=STEDGE/255.16.8.3]",
            "2017-05-30 23:11:33,673 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - Invoking logout agent [accountName=rene1 remoteAddress=STEDGE/172.16.8.3]",
            "2017-05-30 23:11:33,682 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - Logout agent success [accountName=rene1 remoteAddress=STEDGE/172.16.8.3]",
            "2017-05-30 23:11:33,819 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.KeyboardInteractiveAuthentication - SSH: Sent SSH_MSG_USERAUTH_INFO_REQUEST (Password Authentication): ",
            "2017-05-30 23:11:33,871 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - User login attempt has been made from address /172.16.8.1:54626",
            "2017-05-30 23:11:32,042 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - Invoking config agent [accountName=rene1 remoteAddress=gateway/172.16.8.1]",
            "2017-05-30 23:11:32,072 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - Config agent success [accountName=rene1 remoteAddress=gateway/172.16.8.1]",
            "2017-05-30 23:11:31,072 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - Invoking config agent [accountName=rene1 remoteAddress=gateway/172.16.8.1]",
            "2017-05-30 23:11:31,090 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - Config agent success [accountName=rene1 remoteAddress=gateway/172.16.8.1]",
            "2017-05-30 23:11:31,091 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - Invoking auth agent [accountName=rene1 remoteAddress=STEDGE/172.16.8.3]",
            "2017-05-30 23:11:31,095 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - SSH: Failed login attempt on [172.16.8.1]. Username: \"rene1\".",
            "2017-05-30 23:11:18,673 INFO [SSHD-TRANSFER-1] com.tumbleweed.st.server.sshd.AuthenticationProviderImpl - Invoking logout agent [accountName=rene1 remoteAddress=STEDGE/172.16.8.3]");

Predicate<String> predicate = t -> {
        return t.indexOf("remoteAddress=gateway") != -1;
};
List<String> myFilteredList = myList.stream().filter(predicate).collect(Collectors.toList());
System.out.println(myFilteredList);