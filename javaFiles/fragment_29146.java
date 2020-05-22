Treet[] treets = new Treet[0]; 
Treet[] treetsOld = treets;
    try(
System.out.println(treetsOld == treets);
        FileInputStream fis = new FileInputStream("treets.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
    )
    {          
        treets = (Treet[])ois.readObject(); 
System.out.println(treetsOld == treets);
    } catch(IOException ioe) {
        System.out.println(ioe.getMessage());
    } catch(ClassNotFoundException cnfe) {
        System.out.println(cnfe.getMessage());
    }
    return treets;
}