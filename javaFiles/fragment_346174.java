mediabox = pageDict.getAsArray(PdfName.MEDIABOX);
    llx = mediabox.getAsNumber(0).floatValue();
    lly = mediabox.getAsNumber(1).floatValue();
    ury = mediabox.getAsNumber(3).floatValue();
    mediabox.set(0, new PdfNumber((llx - 17)));
    mediabox.set(1, new PdfNumber((lly + 50)));