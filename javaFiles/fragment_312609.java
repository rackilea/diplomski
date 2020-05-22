FastVectorHighlighter highlighter = new FastVectorHighlighter(true, true);
String highlightedResult = highlighter.getBestFragment(
        highlighter.getFieldQuery(myQuery),
        indexReader,
        docId,
        CONTENT_FIELD_NAME,
        50 //char length of fragment
    );