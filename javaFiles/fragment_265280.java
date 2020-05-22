if (!mouseOver(mx, my, 0, 0, 40, 160) && !mouseOver(mx, my, 750, 560, 83, 40)) {
    endX = mx;
    endY = my;
    click = false;
    lineList.add(new MyLine(startX, starY, endX, endY, paint.color));
}