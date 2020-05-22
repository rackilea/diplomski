public class ShowListAction extends AbstractAction {

JTextArea listArea;
YourListHandler listHandler;

public ShowListAction() {
    this.putValue(Action.NAME,"Show List");
    // this.putValue(Action.SMALL_ICON, yourIcon); // You can set various Properties for your Action...
    this.setEnabled(enabled); // You can enable/disable the Action and hence any JButton connected to it ....
}

public void setListArea(JTextArea listArea) {
    this.listArea = listArea;
}

public void setListHandler(YourListHandler listHandler) {
    this.listHandler = listHandler;
}

public void actionPerformed(ActionEvent e) {
  // Here comes the actual work

  // list with data injected from another class which handles that
  List<String> list = listHandler.getNamesList();
  // output - correct
  for (String s : list) {
    listArea.append(s);
  }
}

}