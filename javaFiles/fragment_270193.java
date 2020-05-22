// replaceAll needs regex so "\\s+" (for whitespaces)
 // s+ look for one or more whitespaces
 // replaceAll will replace those whitespaces with single whitespace.
 // trim will remove leading and trailing whitespaces

 name = name.trim().replaceAll("\\s+", " ");