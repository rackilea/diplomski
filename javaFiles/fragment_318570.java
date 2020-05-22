PolylineConnection connection = new PolylineConnection();
    connection.setLineWidth(2);
    connection.setSourceAnchor(new ChannelStartAnchor(this));
    connection.setTargetAnchor(new ChannelEndAnchor(figure));


    Display display = Display.getCurrent();
    final Color connectionColorHoover = display.getSystemColor(SWT.COLOR_RED);
    final Color connectionColor = new Color(display,54,82,111);
    connection.setBackgroundColor(connectionColor);
    connection.setForegroundColor(connectionColor);