public class DDMain {

    public static void main(String[] args) {
        MsgSender sender = new Provider$ASender();
        Resp resp = new RespImpl(sender);
        resp.sendMsg(new TxtMsg("hello world"));
        resp.sendMsg(new PicMsg(new byte[] { 'p', 'i', 'c' }));
    }
}

interface Resp {

    public void sendMsg(Msg msg);
}

class RespImpl implements Resp {

    private MsgSender sender;

    /**
     * 
     */
    public RespImpl(MsgSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendMsg(Msg msg) {
        msg.sendWith(sender);
    }

}

interface Msg {

    byte[] getMsg();

    void sendWith(MsgSender sender);
}

class TxtMsg implements Msg {

    private String string;

    /**
     * @param string
     */
    public TxtMsg(String string) {
        this.string = string;
    }

    @Override
    public void sendWith(MsgSender sender) {
        sender.sendTxtMsg(this);
    }

    @Override
    public byte[] getMsg() {
        return string.getBytes();
    }
}

class PicMsg implements Msg {

    private byte[] data;

    /**
     * 
     */
    public PicMsg(byte[] data) {
        this.data = data;
    }

    @Override
    public void sendWith(MsgSender sender) {
        sender.sendPictureMsg(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see mgage.ott.middleware.newspec.Msg#getMsg()
     */
    @Override
    public byte[] getMsg() {
        return data;
    }
}

interface MsgSender {

    void sendTxtMsg(TxtMsg message);

    void sendPictureMsg(PicMsg rectangle);
}

// this class stays protected and wouldn't be available outside the api.
class Provider$ASender implements MsgSender {

    /**
     * 
     */
    public Provider$ASender() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void sendTxtMsg(TxtMsg message) {
        System.out.println("provider-A sending the txt message "
                + new String(message.getMsg()));
    }

    @Override
    public void sendPictureMsg(PicMsg message) {
        System.out.println("provider-A sending the pic message "
                + new String(message.getMsg()));
    }

}