public void setTableInput(File[] selectedFiles) 
{
  tableViewer.setContentProvider(ArrayContentProvider.getInstance());

  tableViewer.setLabelProvider(new FileLabelProvider());

  tableViewer.setInput(selectedFiles);

  tableViewer.addCheckStateListener(new ICheckStateListener() 
  {
    @Override
    public void checkStateChanged(CheckStateChangedEvent event)
    {
      Object[] filesSelected = tableViewer.getCheckedElements();

      for (Object fileObj : filesSelected)
       {
         File file = (File)fileObj;

         System.out.println("values "+ file.getPath());
       }
    }
  });
}    


private static class FileLabelProvider extends LabelProvider
{
  @Override
  public String getText(final Object element)
  {
    File file = (File)element;

    return file.getName();
  }
}