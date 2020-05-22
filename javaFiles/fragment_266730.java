public class User implements Comparable < User > {

    public String firstName;
    public String surname;
    public int booksOut;

    User(String inFirstName, String inSurname, int inBooksOut){
        this.firstName = inFirstName;
        this.surname = inSurname;
        this.booksOut = inBooksOut;
    }

    public int compareTo(User cmp) {
        int fnCmp = firstName.compareTo(cmp.firstName);
        if (fnCmp != 0) return(fnCmp);
        int snCmp = surname.compareTo(cmp.surname);
        if (snCmp != 0) return(snCmp);
        return(cmp.booksOut-booksOut);
    }   
}