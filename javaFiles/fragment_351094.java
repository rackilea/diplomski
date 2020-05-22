StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);
    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
    StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
    JTextPane output = new JTextPane(document);
    output.setFont(font);