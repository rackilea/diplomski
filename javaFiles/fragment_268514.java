Client_Database database = new Client_Database();
                byte[] contents = new byte[(int) file.length()];
                database.setFileContents(contents);
try {
    FileOutputStream f = new FileOutputStream(new File("C:\\bookCafeDatabase.txt"));
    ObjectOutputStream o = new ObjectOutputStream(f);   
    o.writeObject(result);
    o.close();
    FileInputStream fi = new FileInputStream(new File("C:\\bookCafeDatabase.txt"));
    ObjectInputStream oi = new ObjectInputStream(fi);
    oi.read(contents);
    result = (HashMap<String, Client_Database>)oi.readObject();
    oi.close();
   fi.close();
} catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}