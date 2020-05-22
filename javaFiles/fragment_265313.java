import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Test {

    public static void unma() throws JAXBException {
         JAXBContext jc = JAXBContext.newInstance(Books.class);
         Unmarshaller um = jc.createUnmarshaller();
         Books b = (Books) um.unmarshal(new File("c:/tester/books.xml"));

         for (int i =0;i<b.getBooks().size();i++) {
         Book bb =   b.getBooks().get(i);
         System.out.println(bb.getAuthor());
         System.out.println(bb.getTitle());
         System.out.println(bb.getDescription());
         System.out.println(bb.getGenre());
         System.out.println(bb.getPrice());
         System.out.println(bb.getDate());

         }



    }

    public static void main(String[] args) throws JAXBException {

            unma();
    }

 }