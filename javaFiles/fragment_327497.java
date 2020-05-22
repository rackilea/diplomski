StyleSpan[] ss = e.getSpans(0,e.length(),StyleSpan.class);

for(StyleSpan span : ss){
    int start = e.getSpanStart(span);
    int end = e.getSpanEnd(span);
}