private static final int CONTROL_PORT = 2121;

    public void startStubFtpServer(){
        FakeFtpServer fakeFtpServer = new FakeFtpServer();

        //define the command which should never be answered
        fakeFtpServer.setCommandHandler(CommandNames.PASV, new EverlastingCommandHandler());
        //fakeFtpServer.setCommandHandler(CommandNames.CONNECT, new EverlastingConnectCommandHandler());
        //or any other command...

        //server config
        ...

        //start server
        fakeFtpServer.setServerControlPort(CONTROL_PORT);
        fakeFtpServer.start();

        ...

    }

    //will cause any command received to never have an answer
    public class EverlastingConnectCommandHandler extends org.mockftpserver.core.command.AbstractStaticReplyCommandHandler{
        @Override
        protected void handleCommand(Command cmd, Session session, InvocationRecord rec) throws Exception {
            while(true){
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    //TODO
                }
            }
        }

    }
    public class EverlastingCommandHandler extends AbstractFakeCommandHandler {
        @Override
        protected void handle(Command cmd, Session session) {
            while(true){
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    //TODO
                }
            }
        }
    };