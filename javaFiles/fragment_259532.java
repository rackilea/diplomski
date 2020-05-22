index++;

     stringExcessHours[index] = Double.toString(excessHours[index]);
     buffer2.write(firstLine[index]);
     buffer2.newLine();
     buffer2.write(stringExcessHours[index]);
     buffer2.newLine();