//Close polygon
    path.lineTo(firstPoint.x, firstPoint.y);
    path.setLastPoint(firstPoint.x, firstPoint.y);
    canvas.drawPath(path, paint);
    path.close();
    super.draw(canvas, mapView, shadow);