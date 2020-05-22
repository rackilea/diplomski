public class PortAction extends AbstractAction {

    private CommPortIdentifier port;

    public PortAction(CommPortIdentifier port) {
      this.port = port;
      putValue(SELECTED_KEY, false);
      putValue(NAME, port.getName());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      // Do what ever you want to do with the port...
    }

  }