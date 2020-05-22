class SwitchExample {

    private static final String SUCCESS= "Hey! You have a name doppleganger in the class!";

    public static void main(String[] args) { 
        String name = "person";

        switch(name) {
        case "person1":
            System.out.println(SUCCESS);
            break;

        case "person2":
            System.out.println(SUCCESS);
            break;

        case "person3":
            System.out.println(SUCCESS);
            break;

        case "person4":
            System.out.println(SUCCESS);
            break;

        case "person5":
            System.out.println(SUCCESS);
            break;

        case "person6":
            System.out.println(SUCCESS);
            break;

        case "person7":
            System.out.println(SUCCESS);
            break;

        case "person8":
            System.out.println(SUCCESS);
            break;

        case "person10":
            System.out.println(SUCCESS);
            break;

        default:
             System.out.println("Your name is unique in this class!");

        }
    }
}