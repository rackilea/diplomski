for (Iterator<Element> tabit = rootNode.getChildren( "fichada" ).iterator();
        tabit.hasNext(); ) {

    Element tabla = tabit.next();
    // safely remove one-at-a-time from the document.
    tabit.remove();
    ......

}

// write the modified document back to disk.
....