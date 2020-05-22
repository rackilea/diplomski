FileOutputStream fos = new FileOutputStream("test.dat");
ObjectOutputStream oos = new ObjectOutputStream(fos);

oos.writeObject(list);
oos.flush();
oos.close(); 

FileInputStream fis = new FileInputStream("test.dat");
ObjectInputStream ois = new ObjectInputStream(fis);

List<User> users = (List<User>) ois.readObject();
ois.close();

for(User user : users){
    System.out.println(user.getID() +" " + user.getName());
}