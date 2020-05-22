public class ParentScrollPane extends JScrollPane {
  public ParentScrollPane() {
    JPanel textContainer = new JPanel();

    // I have multiple labels in a for loop, this is
    // just an example
    JLabel sLabel = new JLabel("SOME LABEL TEXT");
    sLabel.setParent(thisPane);
    textContainer.add(sLabel);

    setViewportView(textContainer);
  }

  // this interface is important and key to the solution
  public interface ParentSetter {
    public void setParent(Component p);
  }

  private JScrollPane thisPane;
}

public class CustomLabel extends JLabel implements ParentScrollPane.ParentSetter {
  public CustomLabel(String text) {
    super(text);

    // one event listener is suffice
    addMouseWheelListener(new MouseWheelListener() {
      @Override
      public void mouseWheelMoved(MouseWheelEvent e) {
        // if the Ctrl key is down
        if (e.isControlDown()) {
          // then zoom the font in the JLabel
        } else {
          // then scroll the parent scroll pane
          labelParent.dispatchEvent(e);
        }
      }
    });
  }

  // pay very close attention to this and
  // how the parent scroll pane is set here
  @Override
  public void setParent(Component lParent) {
    labelParent = lParent;
  }

  private Component labelParent;
}