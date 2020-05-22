import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Store_User {
    public static void main(String[] args) {


        User usr1 = new User(1,"Tee Ting Ong", 55.5, 26, Arrays.asList("00000000", "00000000", "00000000"));
        User usr2 = new User(2, "Tee Soon Teh", 54.7, 33, Arrays.asList("00000000", "00000000"));
        User usr3 = new User(3, "Tee Ting Ken", 62.3, 34, Arrays.asList("00000000"));

        ArrayList<User> ulist = new ArrayList<User>();

        ulist.add(usr1);
        ulist.add(usr2);
        ulist.add(usr3);

        Iterator itr=ulist.iterator();

        while(itr.hasNext()){
            User usr = (User)itr.next();
            System.out.println(usr.getUID() +", " + usr.getName() +", " + usr.getAge() +", " + usr.getWeight());

            //This print out the numbers
            String out = "";
            for(String number : usr.getPnum()){
                out += number + ";";
            }
            System.out.println(out);
        }

    }
}