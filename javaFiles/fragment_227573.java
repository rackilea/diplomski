public void saveShell() throws IOException { 
        ObjectOutputStream objectOutputStream = new ObjectOutputStream( 
            new FileOutputStream(getPath())); 

        objectOutputStream.writeObject(new Date()); 
        objectOutputStream.writeBoolean(true); 
        objectOutputStream.writeFloat(1.0f); 

        objectOutputStream.writeObject(shl); 
        objectOutputStream.flush(); 
        objectOutputStream.close(); 
        System.out.println("Successfully saved"); 

    saveShellDB(); //here! 
} 

public Shell loadShell() throws FileNotFoundException, IOException, ClassNotFoundException { 
    loadShellDB(); //here! 
        ObjectInputStream objectInputStream = new ObjectInputStream( 
                new FileInputStream(getPath())); 

        Date date = (Date) objectInputStream.readObject(); 
        System.out.println(date); 
        System.out.println(objectInputStream.readBoolean()); 
        System.out.println(objectInputStream.readFloat()); 

        Shell readShell = (Shell) objectInputStream.readObject(); 
        System.out.println("Shell Loaded"); 

        objectInputStream.close(); 
        System.out.println("Object output stream closed"); 

        return readShell; 
}