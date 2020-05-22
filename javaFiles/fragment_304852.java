import java.io.IOException;

class Student implements java.io.Serializable {

    String name;
    String DOB;
    int id;

    Student(String naam, int idno, String dob) {
        name = naam;
        id = idno;
        DOB = dob;
    }

    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(name);
        stream.writeInt(id);
        stream.writeObject(DOB);
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        name = (String) stream.readObject();
        id = stream.readInt();
        DOB = (String) stream.readObject();
    }

    public String toString() {
        return name + "\t" + id + "\t" + DOB + "\t";
    }

}