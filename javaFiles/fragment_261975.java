PdfContentByte cb = writer.getDirectContentUnder();
cb.saveState();
cb.setLineWidth(1.2);
cb.setColor(BaseColor.DARK_GRAY);
cb.moveTo(x, y);
cb.lineTo(x + width, y);
cb.stroke();
cb.restoreState();