pos = windowList.size();
  if ( pos > 1 && driver.closeCurrentWindow() && windowList.remove() ) {
        log.info( "Closed window at position #" + pos );
  } else {
     log.info("There was a problem closing the window.");
  }