Rectangle rect = getPosition(screening);
ColumnText column = new ColumnText(directcontent);
column.setSimpleColumn(new Phrase(screening.getMovie().getMovieTitle()),
        rect.getLeft(), rect.getBottom(),
        rect.getRight(), rect.getTop(), 18, Element.ALIGN_CENTER);
column.go();