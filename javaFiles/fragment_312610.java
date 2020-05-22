PostingsHighlighter highlighter2 = new PostingsHighlighter();
TopDocs docs = indexSearcher.search(myQuery, 10);
String[] highlightedResults = highlighter.highlight(
        CONTENT_FIELD_NAME, 
        myQuery, 
        indexSearcher, 
        docs
    );