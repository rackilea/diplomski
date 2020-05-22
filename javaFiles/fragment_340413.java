File outputFile = new File(pdfPath);
SVGConverter converter = new SVGConverter();
converter.setDestinationType(DestinationType.PDF);
converter.setSources(new String[] { svgPath });
converter.setDst(outputFile);
converter.execute();