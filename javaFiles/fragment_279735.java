private static ColoredItem createItem(MyCustomInterface obj) {
        ColoredItem item = new ColoredItem();

        int bgColor = .... 
        int color = ....      

        obj.setBackgroundColor(bgColor);
        obj.setForegroundColor(color);
        return item;
}