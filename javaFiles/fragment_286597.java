//panel.add(label1);
    panel.add(label2);
    panel.add(label3);

    //label1.setAlignmentX(Component.CENTER_ALIGNMENT);
    label1.setHorizontalAlignment(JLabel.CENTER); // added
    label2.setAlignmentX(Component.CENTER_ALIGNMENT);
    label3.setAlignmentX(Component.CENTER_ALIGNMENT);

    frame.add(label1, BorderLayout.PAGE_START); // added
    frame.getContentPane().add(panel);