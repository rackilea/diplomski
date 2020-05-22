The easiest way to center a component is to use a GridBagLayout:

JPanel center = new JPanel( new GridBagLayout() );
JLabel imageLabel = new JLabel(...);
center.add(image, new GridBagConstraints());
JLabel textLabel = new JLabel(...);

Then you add your components to the frame using:

add(imageLabel, BorderLayout.CENTER);
add(textLabel, BorderLayout.PAGE_END);