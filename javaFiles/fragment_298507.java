int w=pane.getFontMetrics(pane.getFont()).charWidth(' ');
TabStop[] stops={ new TabStop(0), new TabStop(w*8), new TabStop(w*16),
  new TabStop(w*24), new TabStop(w*32), new TabStop(w*40), new TabStop(w*48),
  new TabStop(w*56), new TabStop(w*64), new TabStop(w*72), new TabStop(w*80) };
MutableAttributeSet attrs=new SimpleAttributeSet();
StyleConstants.setTabSet(attrs, new TabSet(stops) );
pane.setParagraphAttributes(attrs, false);