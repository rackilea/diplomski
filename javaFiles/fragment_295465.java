// lock
htmlDocument.hackWriteLock()

// Get <img src="..."> tag
RunElement imageTagElement = getImageTagElement(htmlDocument);

// Print src attribute value
System.out.println("src : " + runElement.getAttribute(HTML.Attribute.SRC));

// Replace existing src value 
runElement.removeAttribute(HTML.Attribute.SRC);
runElement.addAttribute(HTML.Attribute.SRC, "customValue");

// unlock
htmlDocument.hackWriteUnlock()