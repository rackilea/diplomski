public JPopupMenu useDropPopup;
public JPopupMenu useCancelPopup;

public void init() {
   ActionListener menuListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                String invAction = event.getActionCommand();


                int itemSelect = listbox.getSelectedIndex();
                Object actItem = listbox.getModel().getElementAt(itemSelect);

                System.out.println("Popup menu item [" + invAction + "] [ " + actItem + " ] was pressed.");
            }
        };

   useDropPopup = new JPopupMenu();
   useCancelPopup = new JPopupMenu();

   JMenuItem useMenuItem = new JMenuItem("Use");
   useMenuItem.addActionListener(menuListener);
   JMenuItem dropMenuItem = new JMenuItem("Drop");
   dropMenuItem.addActionListener(menuListener);
   JMenuItem cancelMenuItem = new JMenuItem("Cancel");
   cancelMenuItem.addActionListener(menuListener);

   useDropPopup.add(useMenuItem);
   useDropPopup.add(dropMenuItem);

   useCancelPopup.add(useMenuItem);
   useCancelPopup.add(cancelMenuItem);

   // ... etc bring up the appropriate popup depending on the item.
}