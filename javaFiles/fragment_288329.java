add(license, BorderLayout.CENTER);
JPanel boxes = new JPanel(new FlowLayout());
// FlowLayout is the JPanel default layout manager, so
// boxes = new JPanel(); works too :)
boxes.add(confirmBox);
boxes.add(declineBox);
add(boxes, BorderLayout.SOUTH);