JPopupMenu popup = new JPopupMenu();

final Action actionBeep = new DefaultEditorKit.BeepAction();
final Action actionPaste = new DefaultEditorKit.PasteAction();

final List<Action> actions = new ArrayList<>();
actions.add(actionBeep);
actions.add(actionPaste);
JMenu menu = new JMenu();
// add actions to menu in popup
for (Action action : actions) {
    menu.add(action);
}
// sets the menu's action to the OR-Enabled
menu.setAction(new OrEnabledEmptyAction(actions, "Add"));
popup.add(menu);

JMenuBar bar = new JMenuBar();
JMenu mainMenu = new JMenu();
// add actions to menu in menuBar
for (Action action : actions) {
    mainMenu.add(action);
}
// re-use or-action
mainMenu.setAction(menu.getAction());
bar.add(mainMenu);
frame.setJMenuBar(bar);

JTable table = new JTable(3, 3);

table.setComponentPopupMenu(popup);
// for seeing the effect, change enabled state of only one action
// per released
table.addMouseListener(new MouseAdapter() {
    int index;
    @Override
    public void mouseReleased(MouseEvent e) {
        if (!SwingUtilities.isLeftMouseButton(e))
            return;
        actions.get(index).setEnabled(!actions.get(index).isEnabled());
        index = (index +1) % actions.size();
    }
});