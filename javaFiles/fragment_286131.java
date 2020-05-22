@SuppressWarnings("unchecked")
private void loadDB() {
    try {
        if (db.length() <= 0) {
            // if statement evaluates to true even if file doesn't exists
            saveDB(); // save to a file an empty map
                      // if file doesn't exist, it creates a new one 
                      // call loadDB inside constructor

        }
        FileInputStream fileIn = new FileInputStream(db);
        ObjectInputStream in = new ObjectInputStream(fileIn); // that is where error is produced if fileIn is empty
        in.readObject();
        in.close();
        fileIn.close();
        System.out.println(accounts);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}