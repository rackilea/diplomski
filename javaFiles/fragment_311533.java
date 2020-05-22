JPanel panel = new JPanel(new GridBagLayout());
//panel.setBackground(Color.RED);
panel.setPreferredSize(new Dimension(500, 500));

while (AlarmRS.next()) {
    System.out.println(AlarmRS.getString("Description"));
    panel.add(new JLabel(AlarmRS.getString("Description")));
    //JOptionPane.showInternalMessageDialog(null, getPanel(), AlarmRS.getString("Description"), JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(frame, panel, "This is a title", JOptionPane.WARNING_MESSAGE);
}