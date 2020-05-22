import java.util.Arrays;


class Name implements Comparable<Name> {

    private String lastName;
    //Other fields

    public Name(String lastName){
        this.lastName = lastName;
    }

    public int compareTo(Name o) {
        //Null checks etc
        return lastName.compareTo(o.lastName);
    }
    public String getLastName(){
        return lastName;
    }
    //Getter and setter methods
}

public class Test{
    public static void main(String[] args) {
        Name[] arr = new Name[]{new Name("AAC"), new Name("AAD"), new Name("AAA"),new Name("ABC"), new Name("AADDE")};
        Arrays.sort(arr);
        for(Name nm:arr){
            System.out.println(nm.getLastName());
        }
    }
}