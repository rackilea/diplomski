Canvas c = null;

        try {
            c = mSurfaceHolder.lockCanvas(null);

            synchronized (mSurfaceHolder) {
                if (c != null)
                    c.drawBitmap(blendingImage, 0, 0, null);   // Render blending effect
            }
        } catch (Exception e) {
            Log.e("SurfaceView", "Error drawing frame", e);
        } finally {
            // do this in a finally so that if an exception is thrown
            // during the above, we don't leave the Surface in an
            // inconsistent state
            if (c != null) {
                mSurfaceHolder.unlockCanvasAndPost(c);
            }
        }