for(User user: list){
    //overwrites the file on each loop
    FileOutputStream fos = new FileOutputStream("test.dat");
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.writeObject(user);
    oos.close();
}