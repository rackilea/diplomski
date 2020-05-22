while ((line = br.readLine()) != null) {
     String [] reservoir = line.split(cvsSplitBy);
     SOI = reservoir[1]; // do NOT declare a new string here!
     SGI = reservoir[2];
     SWI = reservoir[3];
     addData();          // invoke addData() with current values
 }