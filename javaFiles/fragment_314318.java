class HyperlinkAction extends TextAction
{
    public HyperlinkAction()
    {
        super("Hyperlink");
    }

    public void actionPerformed(ActionEvent ae)
    {
        JTextComponent component = getFocusedComponent();
        HTMLDocument doc = (HTMLDocument)component.getDocument();
        int position = component.getCaretPosition();
        Element e = doc.getCharacterElement( position );
        AttributeSet as = e.getAttributes();
        AttributeSet anchor = (AttributeSet)as.getAttribute(HTML.Tag.A);

        if (anchor != null)
        {
            try
            {
                Rectangle r = component.modelToView(position);

                MouseEvent me = new MouseEvent(
                    component,
                    MouseEvent.MOUSE_CLICKED,
                    System.currentTimeMillis(),
                    InputEvent.BUTTON1_MASK,
                    r.x,
                    r.y,
                    1,
                    false);

                component.dispatchEvent(me);
            }
            catch(BadLocationException ble) {}
        }
    }
}