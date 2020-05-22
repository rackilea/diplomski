JButton bt = new JButton("Completed");

JComponent s = (JComponent)e.getSource();
JComponent parent = (JComponent) MovingLabel.this.getParent();
parent.remove(MovingLabel.this);
parent.repaint();

bt.addActionListener(new ActionListener() {