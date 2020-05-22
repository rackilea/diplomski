package java7thirdeditionpart1;

public class creatObjectWithoutNewOperator {

    public static void main(String[] args) {

        Class myClass2 = null;
        try {
            myClass2 = Class.forName("java7thirdeditionpart1.Book");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (myClass2 != null) {
            try {
                //Creating an instance of the Book class
                /*Since newInstance returns a
java.lang.Object object, you need to downcast it to its
original type.*/
                Book book1 = (Book) myClass2.newInstance();                
                book1.setAuthor("Khan");                
                book1.setTitle("Second Book");
                book1.setIsbn("kh_s_b");                
                book1.printBookDetails();

                book1 = (Book) myClass2.newInstance();
                book1.setAuthor("Ajmal");
                book1.setTitle("First Book");
                book1.setIsbn("aj_f_b");
                book1.printBookDetails();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }

    }//main method ends here.
}//class creatObjectWithoutNewOperator ends here.