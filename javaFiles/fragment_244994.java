final ScrollBar scrollBar = scrolledComposite.getHorizontalBar();
scrollBar.addSelectionListener( new SelectionAdapter() {
  public void widgetSelected( SelectionEvent event ) {
    if( scrollBar.getSelection() + scrollbar.getThumb() == scrollBar.getMaximum() ) {
      // spawn thread to fetch further data
    }
  }
} );