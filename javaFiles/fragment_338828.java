for (int pageIndex=0; pageIndex< pageable.getNumberOfPages(); pageIndex++) {
   Graphics2D g2d = contentByte.createGraphics(width, height, fontMapper);
   Printable printable = pageable.getPrintable(pageIndex);
   PageFormat pageFormat = pageable.getPageFormat(pageIndex);
   int pageStatus = printable.print(g2d, pageFormat, pageIndex);
   if (pageStatus != Printable.PAGE_EXISTS)
      break;  // something screwey happenned
   g2d.dispose();
}