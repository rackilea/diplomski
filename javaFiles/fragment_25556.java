if (e.getPoint().getX() >= getWidth() - 4) {
                        isRightBorder = true;
                }
                if (e.getPoint().getY() >= getHeight() - 4) {
                        isBottomBorder = true;
                }
                if (e.getPoint().getX() <= 4) {
                        isLeftBorder = true;
                }
                if (e.getPoint().getY() <= 4) {
                        isTopBorder = true;
                }