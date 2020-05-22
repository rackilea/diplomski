public static void main(String[] args) throws Exception {

    ...

    SshServer sshd = SshServer.setUpDefaultServer();

    ...

    sshd.start();

    Thread.sleep(Long.MAX_VALUE);
}