//A
Treet[] treets = new Treet[0]; //at this moment you are declaring the variable and initializing it with an array of 0 spaces
    try(
        FileInputStream fis = new FileInputStream("treets.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
    )
    {   //B        
        treets = (Treet[])ois.readObject(); //at this moment you are replacing the pointer of the previous 0 length array to a new one read from the file

    } catch(IOException ioe) {
        System.out.println(ioe.getMessage());
    } catch(ClassNotFoundException cnfe) {
        System.out.println(cnfe.getMessage());
    }
    return treets;
}