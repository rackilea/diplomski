contentPane = new JPanel();
setContentPane(contentPane);
contentPane.setLayout(null);

JScrollPane scrollPane = new JScrollPane();

//Vertical and Horizontal scroll bar policy is set to choose when the scroll will be visible    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
scrollPane.setBounds(0, 217, 414, 505);
scrollPane.setPreferredSize(new Dimension(414, 414));

JPanel viewport = new JPanel();
viewport.setLayout(null);
viewport.setBounds(0, 0, 414, 505);

//Create your components here, then:
//viewport.add(component)

viewport.setPreferredSize(new Dimension(414, 150));
scrollPane.setViewportView(viewport);
contentPane.add(scrollPane);