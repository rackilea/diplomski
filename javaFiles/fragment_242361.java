cb.BeginText();
cb.SetFontAndSize(font, 11F);

cb.SetCharacterSpacing(1F);
// Fill color (stroke fill)
cb.SetRGBColorFill(0, 0, 0);  
cb.SetLineWidth(0.5F);
// Fill stroke simulate bold
cb.SetTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE);

cb.SetTextMatrix(x, pageSize.Height - y);
cb.ShowTextAligned(PdfContentByte.ALIGN_CENTER, s, (pageSize.Width / 2F), pageSize.Height - y, 0);

cb.EndText();