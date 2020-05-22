for(File file : files) {<BR>
  if(file.lastModified() > storedLastModifiedTime) {<BR>
    // you have the file to process, take care of the line count<BR>
  } else if(file.lastModified() == storedLastModifiedTime) {<BR>
    // reset stored line count<BR>
  }<BR>
}<BR>