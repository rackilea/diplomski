void drawingClickedArea() {
    for (int i = 0; i < 6; i++) {
        canvas.drawLine(i * cellWidth + movedX, 0, i * cellWidth + movedX, getHeight(), pt.pBlack);
    }
    for(int i=0; i<10; i++)
        canvas.drawLine(0, i*cellHeight +iter, getWidth(), i*cellHeight +iter, pt.pBlack);

    iter=iter+5;
    if(iter>cellHeight) iter=0;
}