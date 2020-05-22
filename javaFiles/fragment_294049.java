import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

public class GetIPAddress extends MIDlet implements CommandListener {

  private Display display;
  private Form form = new Form("IP Adress Input");
  private Command submit = new Command("Submit", Command.SCREEN, 1);
  private Command exit = new Command("Exit", Command.EXIT, 1);

  private TextField textfield = new TextField("IP Address:", "", 30, TextField.ANY);

  public GetIPAddress() {
    display = Display.getDisplay(this);
    form.addCommand(exit);
    form.addCommand(submit);
    form.append(textfield);
    form.setCommandListener(this);
  }

  public void startApp() {
    display.setCurrent(form);
  }

  public void pauseApp() {
  }

  public void destroyApp(boolean unconditional) {
  }

  public void commandAction(Command command, Displayable displayable) {
    if (command == submit) {
      // Do the manipulation of the IP address here. 
      // You can retrieve it using textfield.getString();
      form.removeCommand(submit);
    } else if (command == exit) {
      destroyApp(false);
      notifyDestroyed();
    }
  }
}