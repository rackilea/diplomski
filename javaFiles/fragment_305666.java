for (int i = 0; i < offsets.size(); i++){

            Point p = offsets.get(i);

            TextPresentation t = new TextPresentation();
            t.replaceStyleRange(new StyleRange( (int)p.getX(),
                                                (int)(p.getY() - p.getX()),
                                                fgColor.get(i),
                                                null));
            fText.changeTextPresentation(t, true);
        }

    offsets.clear();
    fgColor.clear();