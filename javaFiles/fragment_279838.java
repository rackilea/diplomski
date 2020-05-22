private void checkForCollisionsWithTowers(Ring ring) {
        Stack<Ring> stack = null;
        Sprite tower = null;
        if (ring.collidesWith(mTower1) && (mStack1.size() == 0 || ring.getmWeight() < ((Ring) mStack1.peek()).getmWeight())) {
            stack = mStack1;
            tower = mTower1;
        } else if (ring.collidesWith(mTower2) && (mStack2.size() == 0 || ring.getmWeight() < ((Ring) mStack2.peek()).getmWeight())) {
            stack = mStack2;
            tower = mTower2;
        } else if (ring.collidesWith(mTower3) && (mStack3.size() == 0 || ring.getmWeight() < ((Ring) mStack3.peek()).getmWeight())) {
            stack = mStack3;
            tower = mTower3;
        } else {
            stack = ring.getmStack();
            tower = ring.getmTower();
        }
        ring.getmStack().remove(ring);
        if (stack != null && tower !=null && stack.size() == 0) {
            ring.setPosition(tower.getX() + tower.getWidth()/2 - ring.getWidth()/2, tower.getY() + tower.getHeight() - ring.getHeight());
        } else if (stack != null && tower !=null && stack.size() > 0) {
            ring.setPosition(tower.getX() + tower.getWidth()/2 - ring.getWidth()/2, ((Ring) stack.peek()).getY() - ring.getHeight());
        }
        stack.add(ring);
        ring.setmStack(stack);
        ring.setmTower(tower);

        isGameOver();
    }

    private void isGameOver() {
        if(mStack3.size() == 3){


             Font main_font = FontFactory.create(this.getFontManager(), this.getTextureManager(), 256, 256, BitmapTextureFormat.RGBA_8888, TextureOptions.BILINEAR_PREMULTIPLYALPHA, Typeface.DEFAULT, 60, true, Color.BLACK_ABGR_PACKED_INT);
             main_font.load();

             Text gameOverText = new Text(0, 0, main_font, "GameOver", this.getVertexBufferObjectManager());
             gameOverText.setPosition(CAMERA_WIDTH/2 - gameOverText.getWidth()/2, CAMERA_HEIGHT/2 - gameOverText.getHeight()/2);
             scene.attachChild(gameOverText);

             scene.clearTouchAreas();


       }

        }