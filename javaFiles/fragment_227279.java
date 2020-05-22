You can extending JPopupMenu and add customItem to it:
public class CustomPopUp extends JPopupMenu {

    public CustomPopUp() {
        reload();
    }

    private void reload(final Collection<CustomItem> items) throws BadLocationException {
        for (final CustomItem item : items) {
            add(new AbstractAction(item.getLabel(), item.getIcon()) {               
                @Override
                public void actionPerformed(final ActionEvent e) {
                    //do whatever
                }
            });
        }

    }
}
public class CustomItem {
    private String label;
    private ImageIcon icon;

    //getter and setter
}