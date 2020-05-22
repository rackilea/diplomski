ISourceViewer sourceViewer = getSourceViewer(); // Get your SourceViewer

StyledText styledText = sourceViewer.getTextWidget();

int docOffset = 0;
if (sourceViewer instanceof ITextViewerExtension5) {
    ITextViewerExtension5 extension = (ITextViewerExtension5)sourceViewer;
    docOffset = extension.widgetOffset2ModelOffset(styledText.getCaretOffset());
} 
else {
    int offset = sourceViewer.getVisibleRegion().getOffset();
    docOffset = offset + styledText.getCaretOffset();
}

IDocument document = sourceViewer.getDocument();

int currentLine = document.getLineOfOffset(docOffset);