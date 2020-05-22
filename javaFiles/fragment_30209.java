import java.util.ArrayList;

public class Bag {

    private static ArrayList<Object> collection = new ArrayList();

    public static void main(String[] args) {
        Student student = new Student("Sameet", 1, 4);
        Faculty faculty = new Faculty("Chen", 1000.00, 1);
        Classroom classRoom = new Classroom(1, 10);
        Book book = new Book("Harry Potter", 10);


        collection.add(student);
        collection.add(faculty);
        collection.add(classRoom);
        collection.add(book);
    }

    public void insert(Object obj) {
        collection.add(obj);
    }

    public Student searchForStudent(int ID) {
        for (Object obj : collection) {
            if (obj instanceof Student && ((Student) obj).getId() == ID) {
                return (Student) obj;
            }
        }
        return null;
    }

    public Faculty searchForFaculty(String name) {
        for (Object obj : collection) {
            if (obj instanceof Faculty && name.equals(((Faculty) obj).getName())) {
                return (Faculty) obj;
            }
        }
        return null;
    }

    public Classroom searchForClass(int capacity) {
        for (Object obj : collection) {
            if (obj instanceof Classroom && ((Classroom) obj).getCapacity() == capacity) {
                return (Classroom) obj;
            }
        }
        return null;
    }

    public Book searchForBook(int price) {
        for (Object obj : collection) {
            if (obj instanceof Book && ((Book) obj).getPrice() == price) {
                return (Book) obj;
            }
        }
        return null;
    }
}