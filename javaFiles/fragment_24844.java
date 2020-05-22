@Override
public void columnMarginChanged(final ChangeEvent e)
{
    super.columnMarginChanged(e);

    if (isEditing())
    {
        removeEditor();
    }
    TableColumn resizingColumn = null;
    if (tableHeader != null)
    {
        resizingColumn = tableHeader.getResizingColumn();
    }
    if (resizingColumn != null)
    {
        if (autoResizeMode == AUTO_RESIZE_OFF)
        {
            resizingColumn.setPreferredWidth(resizingColumn.getWidth());
        }
        else
        { 
            SwingUtilities.invokeLater(new Runnable()
            {

                @Override
                public void run()
                {
                    doLayout();
                    repaint();
                }
            });
        }
    }
    else
    {
        resizeAndRepaint();
    }
}