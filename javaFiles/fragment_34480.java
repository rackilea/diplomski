JEditorPane area = new JEditorPane();

  Color bgColor = Color.BLACK;
  UIDefaults defaults = new UIDefaults();
  defaults.put("EditorPane[Enabled].backgroundPainter", bgColor);
  area.putClientProperty("Nimbus.Overrides", defaults);
  area.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
  area.setBackground(bgColor);