FileObject fo = null;
    LineCookie lc = DataObject.find(fo).getLookup().lookup(LineCookie.class);
    int lineNumber=42;
    int colNumber=43;
    Line line = lc.getLineSet().getOriginal(lineNumber);
    line.show(Line.ShowOpenType.OPEN, Line.ShowVisibilityType.FRONT, colNumber);