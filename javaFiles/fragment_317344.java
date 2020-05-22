VerticalFieldManager emojiiVerticalScroll = new VerticalFieldManager(USE_ALL_WIDTH);
VerticalFieldManager stickerhorizontalScroll = new VerticalFieldManager(USE_ALL_WIDTH | VERTICAL_SCROLL | VERTICAL_SCROLLBAR) {

    protected void sublayout(int maxWidth, int maxHeight) {
        setExtent(maxWidth, 250);
        super.sublayout(maxWidth, 250);
    }
};

emojiiBitmapField2 = new BitmapField(emojii1, Field.FIELD_HCENTER | Field.FOCUSABLE) {

    protected void drawFocus(Graphics graphics, boolean on) {
        graphics.setBackgroundColor(0xc4c4c4);
        super.drawFocus(graphics, on);
    };

    protected boolean navigationClick(int status, int time) {
        fieldChangeNotify(1);
        return true;
    };
}; 

Bitmap stickers = Bitmap.getBitmapResource("img/s0010.png");
stickers = bestFit(stickers, Display.getWidth() / 3 - 60, Display.getHeight() / 3, 0);
stikersField = new BitmapField(stickers, Field.FOCUSABLE | DrawStyle.RIGHT) {

    protected void layout(int width, int height) {
        setExtent(60, 60);
        super.layout(60, 60);
    }

    protected void drawFocus(Graphics graphics, boolean on) {
        graphics.setBackgroundColor(0xc4c4c4);
        super.drawFocus(graphics, on);
    }

    protected boolean navigationClick(int status, int time) {
        fieldChangeNotify(1);
        return true;
    }
};