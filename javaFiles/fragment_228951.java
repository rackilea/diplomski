boolean processedFirstLine = false;

 while(...) {
      ...
      if(!processedFirstLine) {
           stuffToDoOnFirstLine(...);
           lineLengthNoted = true;
      }
      ...
 }