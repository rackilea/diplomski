TitledBorder b = null;
...
b = BorderFactory.createTitledBorder(new LineBorder(BLACK, 2),title);
c.setBorder(b);
b = (TitledBorder)c.getBorder();
b.getTitle();