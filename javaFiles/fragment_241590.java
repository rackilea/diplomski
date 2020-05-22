class Foo {
  OptionPane optionPane = new DefaultOptionPane();

  public void someMethod() {
    if (optionPane.showConfirmDialog(null, "choose yes or no", "Please confirm", 
                    JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
                return;

        //User pressed yes
  }    

  public void setOptionPane(OptionPane o) {
    this.optionPane = o;
  }
}

//Snippet of the interface
public interface OptionPane {

   int showConfirmDialog(Component parentComponent,
          Object message, String title, int optionType);
}

public class DefaultOptionPane implements OptionPane {
  @Override
  public int showConfirmDialog(Component parentComponent,
        Object message, String title, int optionType) {

      return JOptionPane.showConfirmDialog(parentComponent,message,title,optionType);
  }
}

public class YesMockOptionPane extends MockOptionPane {

  @Override
  public int showConfirmDialog(Component parentComponent, Object message, String title, int optionType) {
      return JOptionPane.YES_OPTION;
   }
}