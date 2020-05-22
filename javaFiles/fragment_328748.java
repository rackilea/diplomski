Point sel = styledText.getSelection();

int lineNumber = styledText.getLineAtOffset(sel.x);

int lineOffset = styledText.getOffsetAtLine(lineNumber);

int column = sel.x - lineOffset;