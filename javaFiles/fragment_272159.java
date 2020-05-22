@Override
protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics,
                         int tabIndex, String title, Rectangle textRect, boolean isSelected) {

    g.setFont(font);

    View v = getTextViewForTab(tabIndex);
    if (v != null) {
        // html
        v.paint(g, textRect);
    } else {
        // plain text
        int mnemIndex = tabPane.getDisplayedMnemonicIndexAt(tabIndex);

        g.setColor(isSelected ? ANZ_BLUE : Color.WHITE);

        String text;
        int rectX;
        if (metrics.stringWidth(title) <= MAX_TEXT_WIDTH) {
            text = title;
            rectX = textRect.x - (icon.getIconWidth() / 2); //center text
        } else {
            text = clipText(metrics, title);    //clip text
            rectX = textRect.x;
        }

        if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemIndex, rectX,
                                                         textRect.y + metrics.getAscent());

        } else { // tab disabled
            Color bg = tabPane.getBackgroundAt(tabIndex);
            g.setColor(bg.brighter());
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemIndex, rectX,
                                                         textRect.y + metrics.getAscent());
            g.setColor(bg.darker());
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemIndex, rectX - 1,
                                                         textRect.y + metrics.getAscent() - 1);
        }
    }
}