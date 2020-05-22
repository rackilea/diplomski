IEditorPart editor = .... get part ..

Control control = editor.getAdapter(Control.class);

// For a text editor the control will be StyledText

if (control instanceof StyledText) {
  StyledText text = (StyledText)control;

  // Position of caret relative to top left of the control

  Point relPos = text.getLocationAtOffset(text.getCaretOffset()); 

  // Position relative to display

  Point absPos = textWidget.toDisplay(relPos); 
}