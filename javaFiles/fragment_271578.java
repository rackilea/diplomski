public static void searchStudent() {
        String trash= in.nextLine();
        System.out.println("Please Enter First Name");
        String find = in.nextLine();

        for (int i=0; i<users.size(); i++) {
            if(find.equalsIgnoreCase(users.get(i).getfName())){
                System.out.println("Student is Found");
                System.out.println(users.get(i));
                menu();
            }
        }

        System.out.println("Student Not found");
        menu();
}//end of searchStudent