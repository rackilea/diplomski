Map<String, JComponent> currentComponents = new HashMap<String, JComponent>();

currentComponents.put("a", new JButton());

String x = "a";

currentComponents.get(x).setPreferredSize(new Dimension(40,30));