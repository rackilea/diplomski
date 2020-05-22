public static Matrix rotateMatrix(Bitmap bitmap, Shape shape, int rotation) {

        float scaleWidth = ((float) shape.getWidth()) / bitmap.getWidth();
        float scaleHeight = ((float) shape.getHeight()) / bitmap.getHeight();

        Matrix rotateMatrix = new Matrix();
        rotateMatrix.postScale(scaleWidth, scaleHeight);
        rotateMatrix.postRotate(rotation, shape.getWidth()/2, shape.getHeight()/2);
        rotateMatrix.postTranslate(shape.getX(), shape.getY());


        return rotateMatrix;

    }