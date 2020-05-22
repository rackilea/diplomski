public class MyUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    // You need to have some content on the UI, even if it's empty - otherwise it looks odd
    // Here, I'm just adding an empty layout
    VerticalLayout content = new VerticalLayout();
    content.setSizeFull();
    setContent(content);

    // Adding a child window, and centering it for kicks
    Window window = new Window("Help me SO", new SOComplicatedComponent());
    window.center();
    addWindow(window);

  }
}