protected void drawHorizontalLabels(Canvas canvas, float border,
        float horstart, float height, String[] horlabels, float graphwidth) {

    // horizontal labels + lines
    int hors = horlabels.length - 1;
    for (int i = 0; i < horlabels.length; i++) {

        paint.setColor(graphViewStyle.getGridColor());
        float x = ((graphwidth / hors) * i) + horstart;
        if (graphViewStyle.getGridStyle() != GridStyle.VERTICAL) {
            canvas.drawLine(x, height - border, x, border, paint);
        }
        if (showHorizontalLabels) {
            paint.setTextAlign(Align.CENTER);
            if (i == horlabels.length - 1)
                paint.setTextAlign(Align.RIGHT);
            if (i == 0)
                paint.setTextAlign(Align.LEFT);
            paint.setColor(graphViewStyle.getHorizontalLabelsColor());


    //this is where I have added code.

            if (HorDates == true) {
                String[] Text = horlabels[i].split("\\s");

                canvas.drawText(Text[1], x, height - 25, paint);
                canvas.drawText(Text[0], x, height - 15, paint);
            } else {
                canvas.drawText(horlabels[i], x, height - 25, paint);
            }
        }
    }
}