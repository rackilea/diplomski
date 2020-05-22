// declare XMLOutputter 
XMLOutputter xmlOutput = new XMLOutputter();

// declare Format
Format fmt = Format.getPrettyFormat();

// set omit declaration to true
fmt.setOmitDeclaration(true);

// assign Format to XMLOutputter 
xmlOutput.setFormat(fmt);