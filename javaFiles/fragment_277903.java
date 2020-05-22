private static float exifToDegrees(float exifOrientation) {
        // MAY NEED TO HANDLE THE OTHER FLAGS TOO, though I don't think android flips photos.
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            return 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            return 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270;
        }
        return 0;
    }