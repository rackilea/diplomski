if (pressBool) {
                if (stickSprite != null && !stickArray[i].isVisible()
                        && stickArray[i] != null) {
                    if (i == 0) {
                        stickArray[i].setPosition(
                                stickSprite.getX(),
                                stickSprite.getY());
                        stickArray[i].setVisible(true);
                        break;
                    } else if (i > 0) {
                        stickArray[i].setPosition(
                                stickArray[i].getX(),
                                stickArray[i - 1].getY()
                                        - stickArray[i].getHeight());
                        stickArray[i].setVisible(true);
                        break;
                    }
                }
            }