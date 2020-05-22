public AbstractBlock readBlock(int blockNum, AbstractDBFile f)
    throws IOException {

    DBFile dbf = (DBFile) f;
    byte[] data2 = new byte[4096];
    RandomAccessFile file = new RandomAccessFile(dbf.fileName, "r");
    file.seek(4096+blockNum*4096);
    Block b = new Block();

    for (int i = 0; i < 4096; i++){
        try{  
            data2[i] = file.readByte();
        }catch(EOFException ex){
            System.out.println("End of file reached!");

            //break the loop
            break;
         }
    }
    file.close();
    b.setData(data2);
    return b;
}