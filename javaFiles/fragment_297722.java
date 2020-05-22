FileOutputStream fos = new FileOutputStream(outFile);
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(this.getStudents());
oos.close();

FileInputStream fis = new FileInputStream(fileName);
ObjectInputStream ois = new ObjectInputStream(fis);
Student[] copy = (Student[]) ois.readObject();
ois.close();