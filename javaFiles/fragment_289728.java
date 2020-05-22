private BufferedInputStream inFile;

public void basicPageBinarySearchMethod(String filename, int start, int end,
                                        String key, int PageSize, int numPage, int numOfWords) throws IOException{
    inFile = new BufferedInputStream(new FileInputStream(filename));
    ...
}

public void accessPageIndex(int intNum) throws IOException
{
    //This function is skipping intNum integers in the file, to access page's
    //index.
    int i;
    System.out.println(" Accessing page's index...");
    inFile.skip(intNum*4);
    //inFile.readInt();
}
 public void LookingOnLastPage(String key) throws IOException{
    int i, result;
    this.setDiskAccessMeter(this.getDiskAccessMeter()+1);
    System.out.println("Looking for key:"+key+" on last page:"
                                                +(this.getLastPageNo()+1));
    for (i=0; i<this.getLeftElemNum(); i++){
        auxBuffer[i] = String.valueOf((char)inFile.read());
    }
    ...
}
public void fillBasicBuffer(int PageSize) throws IOException{
    //Loading readBuffer.
    int i;
    this.setDiskAccessMeter(this.getDiskAccessMeter()+1);
    for (i=0; i < PageSize; i++){
        char c = (char)inFile.read();
        readBuffer[i] = String.valueOf(c);
    }
}

 public void setFirstNum(String filename) throws IOException {
    inFile = new BufferedInputStream(new FileInputStream(filename));
    this.firstNum = inFile.read();
    inFile.close();
}