import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.wireless.messaging.*;

public class SendSms extends MIDlet implements CommandListener {

    Display display;
    private TextField toWhom;
    private TextField message;
    private Alert alert;
    private Command send, exit;
    MessageConnection clientConn;
    private Form compose;

    public SendSms() {
        display = Display.getDisplay(this);
        compose = new Form("Compose Message");
        toWhom = new TextField("To", "", 10, TextField.PHONENUMBER);
        message = new TextField("Message", "", 600, TextField.ANY);
        send = new Command("Send", Command.BACK, 0);
        exit = new Command("Exit", Command.SCREEN, 5);
        compose.append(toWhom);
        compose.append(message);
        compose.addCommand(send);
        compose.addCommand(exit);
        compose.setCommandListener(this);

    }

    public void startApp() {
        display.setCurrent(compose);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    public void commandAction(Command cmd, Displayable disp) {
        if (cmd == exit) {
            destroyApp(false);
        }
        if (cmd == send) {
            String mno = toWhom.getString();
            String msg = message.getString();
            if (mno.equals("")) {
                alert = new Alert("Alert");
                alert.setString("Enter Mobile Number!!!");
                alert.setTimeout(Alert.FOREVER);
                display.setCurrent(alert);
            } else {
                try {
                    clientConn = (MessageConnection) Connector.open("sms://" + mno);
                } catch (Exception e) {
                    alert = new Alert("Alert");
//                    alert.setString("Unable to connect to Station because of network problem");
                    alert.setString(e.getMessage()+"|"+e.toString());
                    System.out.println(e.getMessage()+"|"+e.toString());
                    alert.setTimeout(2000);
                    display.setCurrent(alert);

                }
                try {
                    TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
                    textmessage.setAddress("sms://" + mno);
                    textmessage.setPayloadText(msg);
                    clientConn.send(textmessage);
                } catch (Exception e) {
                    Alert alert = new Alert("Alert", "", null, AlertType.INFO);
                    alert.setTimeout(Alert.FOREVER);
                    alert.setString(e.getMessage()+"|"+e.toString());
                    System.out.println(e.getMessage()+"|"+e.toString());
                    display.setCurrent(alert);
                }
            }
        }
    }
}