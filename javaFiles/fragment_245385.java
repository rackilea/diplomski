VerticalFieldManager backg = new VerticalFieldManager(Field.USE_ALL_WIDTH | Field.USE_ALL_HEIGHT){
public void paint(Graphics graphics) {
graphics.setBackgroundColor(Color.BLACK);
graphics.clear();
super.paint(graphics);
    }
};