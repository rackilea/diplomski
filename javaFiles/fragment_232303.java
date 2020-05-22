class Testing{

    public Testing(File f)
    {
        this.f = f;
    }

    private File f;
    private int[] intArray;
    public static ReturnClassName className(){
        ReturnClassName returnCN= new ReturnClassName();
        byte[] b;
        if(intArray == null || intArray.length > 0) return //If it was called before, then we don't load the file again.
        {
            try{
                DataInputStream dataIStream= new DataInputStream(new FileInputStream(f));
                intArray= new int[dataIStream.available()];
                b = new byte[dataIStream.available()];
                dataIStream.read(b);
                intArray= b;
                // setting methods for ReturnClassName 
                // counter increment
            } catch(Exception e) { 
            ...
            ...
            }
        }
        returnCN.setNumber(someMethod(5));
        return returnCN;
    }

    private int[] someMethod(int l){
        return Arrays.copyOfRange(intArray, counter, counter + l);
    }
}