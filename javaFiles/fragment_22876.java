final Bitmap bg=Bitmap.getBitmapResource("background.png");
    VerticalFieldManager top = new VerticalFieldManager(Manager.NO_HORIZONTAL_SCROLL | Manager.NO_HORIZONTAL_SCROLLBAR | Manager.VERTICAL_SCROLL | Manager.VERTICAL_SCROLLBAR | Field.USE_ALL_WIDTH){
        public void paint(Graphics graphics) {
            graphics.setBackgroundColor(Color.WHITE);
            graphics.clear();
            graphics.drawBitmap(0, 0, bg.getWidth(),
                    bg.getHeight(), bg, 0, 0);
            super.paint(graphics);
        }

    };


final Bitmap logo= Bitmap.getBitmapResource("logo.png");
top .add(new BitmapField(logo));
add(top);