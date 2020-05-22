public class PositionHolder {
  private int oldPosition;
  private Position position;
  private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
  public PositionHolder(Position aPos) {
    position = aPos;
    oldPosition = aPos.getOffset();
  }
  public void addPropertyChangeListener(PropertyChangeListener aListener) {
    propertySupport.addPropertyChangeListener(aListener);
  }
  // same for remove listener
  public void verifyPosition() {
    // no custom if statement required - event is fiered only when old != new
    propertySupport.firePropertyChangeEvent("position", oldPosition, position.getOffset());
    oldPosition = position.getOffset();
  }
  public Position getPosition() {
    return position;
  }
}

public class PositionUpdater implements DocumentListener {
  private List<PositionHolder> holders;
  public PositionUpdater(List<PositionHolder> someHolders) {
    holders = someHolders;
  }

  public void insertUpdate(DocumentEvent e) {
    for (PositionHolder h : holders) {
      h.verifyPosition();
    }
  }
  public void removeUpdate(DocumentEvent e) {
    insertUpdate(e);
  }
  public void changeUpdate(DocumentEvent e) {
    insertUpdate(e);
  }
}

JTextComponent textComp = // your text component
List<PositionHolder> holderList = new ArrayList<>(); // your list of positions
textComp.getDocument().addDocumentListener(new PositionUpdater(holderList));