Queue currentQueue;
Element currentElement;

startElement(node){
  if( node is queue )
     currentQueue = new Queue();
  else if( node is element )
     currentElement = new Element(); 
}

characters( chars ) {
  currentElement.setName( chars );
}

endElement(node){
  if( node is queue )
     currentQueue = null;
  else if( node is element ) {
     currentQueue.add( currentElement ); <-- that's the important part
     currentElement = null; 
  }
}