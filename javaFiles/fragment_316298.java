public class SftpClient {

    private final JSch jSch;

    private Session session;
    private ChannelSftp channelSftp;
    private boolean connected;

    public SftpClient() { this.jSch = new JSch(); }

    public void connect(final ConnectionDetails details) throws ConnectionException {
        try {
            if (details.usesDefaultPort()) {
                session = jSch.getSession(details.getUserName(), details.getHost());
            } else {
                session = jSch.getSession(details.getUserName(), details.getHost(), details.getPort());
            }
            channelSftp = createSftp(session, details.getPassword());
            channelSftp.connect();

            connected = session.isConnected();
        } catch (JSchException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    public void disconnect() {
        if (connected) {
            channelSftp.disconnect();
            session.disconnect();
        }
    }

    public void cd(final String path) throws FileActionException {
        try {
            channelSftp.cd(path);
        } catch (SftpException e) {
            throw new FileActionException(e.getMessage());
        }
    }

    public List<FileWrapper> list() throws FileActionException {
        try {
            return collectToWrapperList(channelSftp.ls("*"));
        } catch (SftpException e) {
            throw new FileActionException(e.getMessage());
        }
    }

    public String pwd() throws FileActionException {
        try {
            return channelSftp.pwd();
        } catch (SftpException e) {
            throw new FileActionException(e.getMessage());
        }
    }

    public boolean rename(final FileWrapper wrapper, final String newFileName) throws FileActionException {
        try {
            String currentPath = channelSftp.pwd();
            channelSftp.rename(currentPath + wrapper.getFileName(), currentPath + newFileName);
        } catch (SftpException e) {
            throw new FileActionException(e.getMessage());
        }
        return true;
    }

    private List<FileWrapper> collectToWrapperList(Vector<ChannelSftp.LsEntry> entries) {
        return entries.stream()
        .filter(entry -> !entry.getAttrs().isDir())
        .map(entry -> FileWrapper.from(entry.getAttrs().getMtimeString(), entry.getFilename(), entry.getAttrs().getSize()))
        .collect(Collectors.toList());
    }

    private ChannelSftp createSftp(final Session session, final String password) throws JSchException {
        session.setPassword(password);
        Properties properties = new Properties();
        properties.setProperty("StrictHostKeyChecking", "no");
        session.setConfig(properties);
        session.connect();

    return (ChannelSftp) session.openChannel("sftp");
    }
}