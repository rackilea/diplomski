line = reader.readNext();
 if(line != null) {
     stuffToDoOnlyOnFirstLine(...);
 }
 while(line != null) {
     stuffToDoOnAllLines(...);
     line = reader.readNext();
 }