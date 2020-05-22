string line = ReadField(myReader); // This reads up to the next field

if(line.contains("<#FIELD NAME = AUTOR>")){
   String autor = line.substring(line.indexOf(">")+1,line.indexOf("</#"));
   metaData.setAutor(autor.trim());
} else if(line.contains("<#FIELD NAME = DOKUMENTNR>")) {
   String dokumentnr = line.substring(line.indexOf(">")+1,line.indexOf("</#"));
   metaData.setDoukumentnr(dokumentnr.trim());
}