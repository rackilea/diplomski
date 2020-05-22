JPanel buttonPanel = new JPanel(...);
JLabel image = new JLabel(...);

JPanel center = new JPanel( new BorderLayout() );
center.add(image, BorderrLayout.CENTER);
center.add(buttonPanel, BorderLayout.PAGE_END);

JPanel leftPanel = new JPanel(...);
JPanel rightPanel = new JPanel(...);

frame.add(leftPanel, BorderLayout.LINE_START);
frame.add(center, BorderLayout.CENTER);
frame.add(rightPanel, BorderLayout.LINE_END);