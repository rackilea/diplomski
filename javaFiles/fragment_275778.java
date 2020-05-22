public class ActionManager {

    public ActionManager() {

    }

    Action openDialog1Action = new AbstractAction("Open Dialog 1") {
        JOptionPane.showMessageDialog(null, "Dialog 1");
    }

    Action openDialog2Action = new AbstractAction("Open Dialog 2") {
        JOptionPane.showMessageDialog(null, "Dialog 2");
    }

}