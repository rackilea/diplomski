public  boolean isCollisionDetected(byte[] pixels1, Bitmap bitmap1, int x1, int y1,
            byte[] pixels2, Bitmap bitmap2, int x2, int y2) {

        int width1 =bitmap1.getWidth();
        int height1=bitmap1.getHeight();
        int width2 =bitmap2.getWidth();
        int height2=bitmap2.getHeight();

        Rect bounds1 = new Rect(x1, y1, x1 + width1, y1 + height1);
        Rect bounds2 = new Rect(x2, y2, x2 + width2, y2 + height2);

        if (Rect.intersects(bounds1, bounds2)) {
            Rect collisionBounds = getCollisionBounds(bounds1, bounds2);
            for (int i = collisionBounds.left; i < collisionBounds.right; i++) {
                for (int j = collisionBounds.top; j < collisionBounds.bottom; j++) {
                    byte bitmap1Pixel = pixels1[((j - y1) * width1) + (i - x1)];
                    byte bitmap2Pixel = pixels2[((j - y2) * width2) + (i - x2)];
                    if (isFilled(bitmap1Pixel) && isFilled(bitmap2Pixel)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }