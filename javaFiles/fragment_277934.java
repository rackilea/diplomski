contactHorizontalScrollPanel = new ScrollPanel();

HorizontalPanel hPanel = new HorizontalPanel();
for (int i = 0; i < 5; i++) {
     Button btn = new Button("" + i);
     hPanel.add(btn);
}

contactHorizontalScrollPane.setWidget(hPanel);