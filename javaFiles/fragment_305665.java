for (Point p : offsets){
        TextPresentation t = new TextPresentation();

        t.replaceStyleRange(new StyleRange( (int)p.getX(),
                (int)(p.getY() - p.getX()),
                null,
                Color.win32_new(null, 0xDDDDDD)));

        fText.changeTextPresentation(t, true);
    }