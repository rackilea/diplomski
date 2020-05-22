Graphics graphics = panelRegion.getGraphics();

Runnable methodCall = new Runnable() {
   public void run() {
       graphics.drawRectangle(xPos, yPos, width, height);
    }
}

panelRegion.addMethod(methodCall);