JPanel panel=new JPanel();
   panel.setBounds(20,300,700,300);
   add(panel);
   tabel=new JTable(data,columnNames);
   tabel.setBounds(100,20,700,400);
   tabel.setPreferredScrollableViewportSize(new Dimension(500,50));
   tabel.setFillsViewportHeight(true);
   JScrollPane pane=new JScrollPane(tabel);
   panel.add(pane);