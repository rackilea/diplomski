public class ActionExit extends AbstractAction
{
  private Model model;

  public ActionExit(Model model)
  {
    this.model = model;
    putValue(NAME, "Exit");
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    System.exit(0);
  }
}