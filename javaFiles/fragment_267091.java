public class Project {
    static String message = "default message";
    public static void main(String args[]) {
        String newMessage = "new message";
        UserMod userMod = new UserMod();
        userMod.modifyText(newMessage());
        System.out.println(message);
    }
}