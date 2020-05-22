mediaModel=mProvider.getNextMenu(paramsCid);
medialist = new JList(mediaModel);
medialist.setOpaque(false);         
medialist.setCellRenderer(new MediaCellRenderer());

panel = new JScrollPane(medialist);
panel.setPreferredSize(new Dimension(300,300));
pane1.setOpaque(true);