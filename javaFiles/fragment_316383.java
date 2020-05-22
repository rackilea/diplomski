JPanel panel = new JPanel();
panel.setPreferredSize( button.getPreferredSize() );
GridBagLayout layout = (GridBagLayout)p.getLayout();
GridBagConstraints gbc = layout.getConstraints( button );
p.remove(button);
p.add(panel, gbc);
p.revalidate();
p.repaint();