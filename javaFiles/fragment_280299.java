final ListenerImpl l = new ListenerImpl();
for (Component c : getComponents()) {
   if (c instanceof JSpinner) {
      ((JSpinner)c).addChangeListener(l);
   } else if (c instanceof JTextPane ) { } // ... other types of components
}