if (e.getSource() == cmdYes) {
            new UIManager();
            UIManager.put("OptionPane.background", new ColorUIResource(0, 255, 0));
            UIManager.put("Panel.background", new ColorUIResource(0, 255, 0));
            JOptionPane.showMessageDialog(null, "Green Message", "Green", JOptionPane.INFORMATION_MESSAGE);
}
if (e.getSource() == cmdNo) {
            new UIManager();
            UIManager.put("OptionPane.background", new ColorUIResource(255, 0, 0));
            UIManager.put("Panel.background", new ColorUIResource(255, 0, 0));
            JOptionPane.showMessageDialog(null, "Red Message", "Red", JOptionPane.INFORMATION_MESSAGE);
}