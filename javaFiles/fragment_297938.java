SurfaceHolder surfaceHolder = surfaceView.getHolder();
 Canvas canvas = surfaceHolder.getSurface().lockCanvas();

 //draw in the canvas
 canvas.drawPoint(...);

 surfaceHolder.unlockCanvasAndPost(canvas);