import java.util.HashMap;


    public class MapTester{

        HashMap<String, String> phoneBook = new HashMap<String, String>();

        public void main(String args[])
        {

            phoneBook.put("Jenna Simpson", "3424 6785");

         }


        public void enterNumber (String name, String number)
        {
            phoneBook.put(name, number);
        }

    }