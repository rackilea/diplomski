for (MyImage image: images) {
        if (!image.isDraw()) {
            image.setDraw(true);
            break;
        }
    }
    repaint();