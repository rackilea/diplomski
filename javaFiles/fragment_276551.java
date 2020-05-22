boolean foundBody = false;
while(!foundBody && xsr.hasNext()) {
  if(xsr.next() == XMLStreamConstants.START_ELEMENT &&
     "http://www.w3.org/2003/05/soap-envelope".equals(xsr.getNamespaceURI()) &&
     "Body".equals(xsr.getLocalName())) {
    foundBody = true;
  }
}

// if foundBody == true, then xsr is now pointing to the opening Body tag.
// if foundBody == false, then we ran out of document before finding a Body

if(foundBody) {
  // advance to the next tag - this will either be the opening tag of the
  // element inside the body, if there is one, or the closing Body tag if
  // there isn't
  if(xsr.nextTag() == XMLStreamConstants.START_ELEMENT) {
    // now pointing at the opening tag of GetForkliftPositionResponse
  } else {
    // now pointing at </env:Body> - body was empty
  }
}