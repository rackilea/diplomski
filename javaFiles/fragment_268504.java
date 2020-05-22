private void PlaceChunck(String text, int x, int y) {
        PdfContentByte cb = writer.DirectContent;
        BaseFont bf = BaseFont.CreateFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        cb.SaveState();
        cb.BeginText();
        cb.MoveText(x, y);
        cb.SetFontAndSize(bf, 12);
        cb.ShowText(text);
        cb.EndText();
        cb.RestoreState();
    }