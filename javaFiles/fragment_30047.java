Border b = null;
...
b = BorderFactory.createTitledBorder(new LineBorder(BLACK, 2),title);
c.setBorder(b);
b = c.getBorder();
( (TitledBorder)b ).getTitle();