public FileRecord [] calcPos() throws IOException{
     FileRecord[] array = new FileRecord[header.getMaxFileRecords()]; 
     for (int i = 0; i < getEFSFATmaxRecords(); i++){
       int blockNumber = i/5;
       int recordOffset = i%5;
       pos = (recordOffset*100+(getFsatPos() + 512 + 512*blockNumber)); 
       FileRecord rec = new FileRecord(pos,getHeader());
       array[i] = rec;
       System.out.println("FileName: " + array[i].getFileName());
    }
    return array;
}