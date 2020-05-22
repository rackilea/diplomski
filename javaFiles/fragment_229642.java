KeyListener keyListener = new KeyLisener()
{
    public void keyPressed(KeyEvent evt)
    {
        if (evt.keyCode == SWT.TAB)
        {
            // There are numerous setSelection methods.  I'll leave this to you. 
            tableViewer.getTable().setSelection(...)
        }
    }

    public void keyReleased(KeyEvent evt){}
}

TraverseListener traverseListener = new TraverseListener()
{
    public void keyTraversed(TraverseEvent evt)
    {
        if (evt.keyCode == SWT.TAB)
            evt.doit = false;
    }
}

tableViewer.getTable().addKeyListener(keyListener);
tableViewer.getTable().addTraverseListener(traverseListener);