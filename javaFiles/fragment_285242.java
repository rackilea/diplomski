public class Creator { //  -------------- renamed: was "creator"
    public static void main(String[] arg) {
        PersonalId john = new PersonalId("John");
        System.out.println("John's id: "+ john.getId());
        System.out.println("John's name: "+ john.getName());
    }
}