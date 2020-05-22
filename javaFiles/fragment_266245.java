/**
   * Returns the shortest CSS path identify a given element. Note that this
   * will not return a unique element, but can be used to obtain all elements
   * that match the selector returned.
   * 
   * @param cssElement The element that must be identified by its CSS selector.
   * @return The CSS selector for the given element, or the empty string if
   * no selector is found.
   */
  private String cssPath( Element cssElement ) {
    StringBuilder result = new StringBuilder( 256 );

    String id = cssElement.id();

    // If the element has an ID, then return it as the shortest path (IDs are
    // supposed to be unique).
    if( id.length() > 0 ) {
      // This will break the chain of recursion.
      result.append( '#' ).append( id );
    }
    else {
      Element parent = cssElement.parent();

      // If there is a parent node, then recurse to determine its CSS path.
      // Otherwise, the chain of recursion ends here.
      if( parent != null ) {
        result.append( cssPath( parent ) );
      }

      // Generate a CSS path using the element's tag name and classes.
      if( cssElement.className().length() > 0 ) {
        result.append( " > " ).append( cssElement.tagName() );
        Set<String> cssClasses = cssElement.classNames();
        cssClasses.forEach( c -> result.append( '.' ).append( c ) );
        result.append( ' ' );
      }
    }

    // Return the (possibly incomplete) CSS selector through recursion.          
    return result.toString();
  }