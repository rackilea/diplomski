@Override
public void run(){
    Canvas canvas;
    while (running){
        canvas = null;
        try {
            canvas = this.surfaceHolder.lockCanvas();
            synchronized (surfaceHolder){
                this.gamePanel.update();
                canvas = gameLine.drawTheLine();
            }
        }finally {
            if(canvas != null){
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}