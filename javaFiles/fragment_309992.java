JScrollPane paneA = new JScrollPane(listA);
paneA.setPreferredSize(new Dimension(paneA.getPreferredSize().height, 300));
listB.addMouseListener(listener);
JScrollPane paneB = new JScrollPane(listB);
paneB.setPreferredSize(new Dimension(paneB.getPreferredSize().height, 300));
listC.addMouseListener(listener);
JScrollPane paneC = new JScrollPane(listC);
paneC.setPreferredSize(new Dimension(paneC.getPreferredSize().height, 300));