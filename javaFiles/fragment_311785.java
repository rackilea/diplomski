panel = new JPanel();
    frame.setLayout(new GridLayout());

    this.scrollBar = new JScrollPane();
    scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    frame.getContentPane().add(scrollBar, BorderLayout.EAST);

    displayImages();

    frame.setContentPane(panel);