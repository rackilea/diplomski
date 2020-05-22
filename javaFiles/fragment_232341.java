GridBagLayout layout = new GridBagLayout();
JPanel panel = new JPanel(layout);
...
layout.setConstraints(myComponent, anotherConstraint);
// do this for all the components you want to update
panel.revalidate();
panel.repaint();