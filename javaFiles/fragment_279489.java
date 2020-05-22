{
            HTMLEditorKit kit = new HTMLEditorKit();
            HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
            doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
            Reader HTMLReader = new InputStreamReader(testURL.openConnection().getInputStream());
            kit.read(HTMLReader, doc, 0);
            String title = (String) doc.getProperty(Document.TitleProperty);
            System.out.println(title);
    }