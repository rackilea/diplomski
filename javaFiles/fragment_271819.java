public void write(Writer out, Document doc, int pos, int len) throws IOException, BadLocationException
        {
            if (doc instanceof HTMLDocument)
            {
                FixedHTMLWriter w = new FixedHTMLWriter(out, (HTMLDocument) doc, pos, len);
                w.write();
            }
            else if (doc instanceof StyledDocument)
            {
                MinimalHTMLWriter w = new MinimalHTMLWriter(out, (StyledDocument) doc, pos, len);
                w.write();
            }
            else
            {
                super.write(out, doc, pos, len);
            }
        }