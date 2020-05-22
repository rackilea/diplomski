public class SOComplicatedComponent extends CustomComponent {

  private VerticalLayout mainLayout;
  private TextArea textArea;
  private Button button;

  public SOComplicatedComponent() {
    buildMainLayout();
    setCompositionRoot(mainLayout);
  }

  private VerticalLayout buildMainLayout() {
    // common part: create layout
    mainLayout = new VerticalLayout();
    mainLayout.setSpacing(true);
    mainLayout.setMargin(true);

    // top-level component properties
    /* CSA : SizeUndefined means "take as much space as my content needs" */
    setSizeUndefined();

    // textArea
    textArea = new TextArea();
    textArea.setValue("hey, this button is supposed to be under me!");
    textArea.setSizeUndefined();
    mainLayout.addComponent(textArea);

    //button
    button = new Button("Ooops");
    button.setSizeUndefined();
    mainLayout.addComponent(button);

    return mainLayout;
  }

}