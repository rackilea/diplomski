137   public void installUI(JComponent c) {
138       optionPane = (JOptionPane)c;
139       installDefaults();
140       optionPane.setLayout(createLayoutManager());
141       installComponents();
142       installListeners();
143       installKeyboardActions();
144   }