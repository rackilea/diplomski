ColumnText ct = new ColumnText(cb);
ct.setSimpleColumn(120f, 500f, 250f, 780f);
Paragraph p = new Paragraph("This is a long paragraph that doesn't"
        + "fit the width we defined for the simple column of the" 
        + "ColumnText object, so it will be distributed over several"
        + "lines (and we don't know in advance how many).");
ct.addElement(p);
ct.go();