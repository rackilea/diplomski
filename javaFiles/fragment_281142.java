GridBagConstraints gbc;
final int A_CENTER = GridBagConstraints.CENTER;  // anchor: center
final int F_NONE = GridBagConstraints.NONE;  // fill: none
final int F_DX = GridBagConstraints.HORIZONTAL;  // fill: dx only
final Insets IN_0 = new Insets(0, 0, 0, 0);  // empty insets

setLayout(new GridBagLayout() );
gbc = new GridBagConstraints(0, 0, 1, 1, 50.0, 0.0, A_CENTER, F_DX, IN_0, 0, 0);
add(new JButton("test1"), gbc);
gbc = new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, A_CENTER, F_NONE, IN_0, 0, 0);
add(new JButton("test2"), gbc);
gbc = new GridBagConstraints(2, 0, 1, 1, 50.0, 0.0, A_CENTER, F_DX, IN_0, 0, 0);
add(new JButton("test1"), gbc);