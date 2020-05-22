Rectangle layoutRect = new Rectangle(w,h);
LayoutArea layoutArea = new LayoutArea(1,layoutRect);
LayoutContext context = new LayoutContext(layoutArea);

Text layoutText  = new Text(s);
layoutText.setTextRise(0f);
layoutText.setSplitCharacters(new DefaultSplitCharacters());
layoutText.setFont(font);
layoutText.setFontSize(fontSize);

Paragraph p = new Paragraph().add(layoutText);
LayoutResult hwResult = p.createRendererSubTree().layout(context);